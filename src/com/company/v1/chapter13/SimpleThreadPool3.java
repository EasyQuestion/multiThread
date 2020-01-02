package com.company.v1.chapter13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

//添加线程池的停止方法
public class SimpleThreadPool3 {

    private final int size;
    private final static int DEFAULT_SIZE = 10;
    private static volatile int seq;

    private final int taskSize;
    private final static int DEFAULT_TASK_SIZE = 2000;

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";
    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();
    private final static List<Worker> THREAD_QUEUE = new ArrayList<>();

    private final DiscardStrategy discardStrategy;

    public final static DiscardStrategy DEFAULT_DISCARD_STRATEGY = ()->{
        throw new DiscardException(" is discard by pool. ");
    };

    private volatile boolean destroy = false;

    public SimpleThreadPool3() {
        this(DEFAULT_SIZE, DEFAULT_TASK_SIZE,DEFAULT_DISCARD_STRATEGY);
    }

    public SimpleThreadPool3(int size, int taskSize, DiscardStrategy discardStrategy) {
        this.size = size;
        this.taskSize = taskSize;
        this.discardStrategy = discardStrategy;
        init();
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            createWorker();
        }
    }

    private void createWorker() {
        Worker worker = new Worker(GROUP, THREAD_PREFIX + (seq++));
        worker.start();
        THREAD_QUEUE.add(worker);
    }

    public void submit(Runnable runnable) {

        if(destroy){
            throw new IllegalStateException("The thread pool already destroy and not allow submit task.");
        }

        synchronized (TASK_QUEUE) {
            if (TASK_QUEUE.size() >= taskSize) {
                discardStrategy.discard();
            } else {
                TASK_QUEUE.addLast(runnable);
                TASK_QUEUE.notifyAll();
            }
        }
    }

    //先看有没有还要做的任务
    //没有等待的任务，看还有没有阻塞的线程，把阻塞的线程Interrupt了
    public void shutdown() throws InterruptedException {
        while (!TASK_QUEUE.isEmpty()){
            Thread.sleep(50);
        }
        int threadNum = THREAD_QUEUE.size();
        while(threadNum>0){
            for(Worker worker:THREAD_QUEUE){
                if(worker.workState == WorkState.BLOCKED){
                    worker.interrupt();
                    worker.close();
                    threadNum--;
                }else{
                    Thread.sleep(10);
                }
            }
        }

        destroy = true;
        System.out.println("The thread pool disposed.");
    }

    public int getSize() {
        return size;
    }

    public int getTaskSize() {
        return taskSize;
    }

    public boolean isDestroy() {
        return destroy;
    }

    public interface DiscardStrategy{
        void discard()throws DiscardException;
    }

    private static class DiscardException extends RuntimeException {
        public DiscardException(String message) {
            super(message);
        }
    }

    private enum WorkState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    private class Worker extends Thread {

        private volatile WorkState workState = WorkState.FREE;

        private Runnable runnable;

        public Worker(ThreadGroup tg, String name) {
            super(tg, name);
        }

        @Override
        public void run() {
            //线程状态不是停止状态，就一直运行
            OUTER:
            while (this.workState != WorkState.DEAD) {
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            workState = WorkState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;//如果有人打断，就退出到外层循环，结束方法
                        }
                    }
                    //获取到任务，执行
                    runnable = TASK_QUEUE.removeFirst();
                }
                if (runnable != null) {
                    workState = WorkState.RUNNING;
                    runnable.run();
                    //运行结束
                    workState = WorkState.FREE;
                }
            }
        }

        public WorkState getWorkState() {
            return workState;
        }

        public void close() {
            this.workState = WorkState.DEAD;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool3 simpleThreadPool = new SimpleThreadPool3();
        IntStream.rangeClosed(0, 40).forEach(i -> {
            simpleThreadPool.submit(() -> {
                System.out.println("The runnable " + i + " be serviced by " + Thread.currentThread().getName() + " start.");
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The runnable " + i + " be serviced by " + Thread.currentThread().getName() + " finished.");
            });
        });

        Thread.sleep(10_000);

        simpleThreadPool.shutdown();

//        simpleThreadPool.submit(()->{System.out.println("=======================");});
    }
}
