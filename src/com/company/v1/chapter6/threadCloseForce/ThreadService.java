package com.company.v1.chapter6.threadCloseForce;

public class ThreadService {

    private Thread thread;

    private boolean finished = false;

    public void execute(Runnable task) {
        thread = new Thread(() -> {
            Thread thread1 = new Thread(task);
            thread1.setDaemon(true);
            thread1.start();

            try {
                thread1.join();
                finished = true;
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        });

        thread.start();
    }

    public void shutdown(long mills) {
        long current = System.currentTimeMillis();

        while (!finished) {
            if (System.currentTimeMillis() - current >= mills) {
                System.out.println("任务超时，暴力停止！");
                thread.interrupt();
                break;
            }

            try {
                thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断！");
                break;
            }
        }
    }
}
