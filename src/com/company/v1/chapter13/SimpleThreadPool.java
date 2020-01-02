package com.company.v1.chapter13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

//完成一个简单的线程池，添加任务，控制线程数量
public class SimpleThreadPool {

    private final int size;
    private final static int DEFAULT_SIZE = 10;
    private static volatile int seq;

    private final static String THREAD_PREFIX = "SIMPLE_THEAD_POOL-";
    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();
    private final static List<Worker> THREAD_QUEUE = new ArrayList<>();

    public SimpleThreadPool() {
        this(DEFAULT_SIZE);
    }

    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }

    private void init(){
        for(int i=0;i<size;i++){
            createWorker();
        }
    }

    private void createWorker(){
        Worker worker = new Worker(GROUP,THREAD_PREFIX+(seq++));
        worker.start();
        THREAD_QUEUE.add(worker);
    }

    public void submit(Runnable runnable){
        synchronized (TASK_QUEUE){
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private enum WorkState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    private class Worker extends Thread {

        private volatile WorkState workState = WorkState.FREE;

        private Runnable runnable;

        public Worker(ThreadGroup tg,String name){
            super(tg,name);
        }

        @Override
        public void run() {
            //线程状态不是停止状态，就一直运行
            OUTER:
            while(this.workState != WorkState.DEAD) {
                synchronized (TASK_QUEUE) {
                    while(TASK_QUEUE.isEmpty()){
                        try {
                            workState = WorkState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;//如果有人打断，就退出到外层循环
                        }
                    }
                    //获取到任务，执行
                    runnable = TASK_QUEUE.removeFirst();
                }
                if(runnable != null){
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

    public static void main(String[] args) {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();
        IntStream.rangeClosed(0,40).forEach(i->{
            simpleThreadPool.submit(()->{
                System.out.println("The runnable "+i+" be serviced by "+Thread.currentThread().getName()+" start.");
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The runnable "+i+" be serviced by "+Thread.currentThread().getName()+" finished.");
            });
        });
    }
}
