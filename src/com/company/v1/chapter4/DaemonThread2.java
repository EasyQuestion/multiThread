package com.company.v1.chapter4;

public class DaemonThread2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{

            System.out.println("t1 start.");

            Thread t2 = new Thread(()->{
                try {
                    while(true) {
                        System.out.println("t2 do something for health check.");
                        Thread.sleep(1_000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            t2.setDaemon(true);
            t2.start();

            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 finished done.");
        });

//        t1.setDaemon(true);
        t1.start();
        System.out.println("end");
    }
}
