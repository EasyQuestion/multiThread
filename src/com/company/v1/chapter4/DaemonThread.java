package com.company.v1.chapter4;

public class DaemonThread {

    public static void main(String[] args)throws InterruptedException {
        Thread thread = new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+" start.");
                    Thread.sleep(100000);
                    System.out.println(Thread.currentThread().getName()+" end.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        thread.setDaemon(true);
        thread.start();
        Thread.sleep(10_000);
        System.out.println(Thread.currentThread().getName());
    }
}
