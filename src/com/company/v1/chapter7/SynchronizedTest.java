package com.company.v1.chapter7;

public class SynchronizedTest {

    private final static Object MONITOR = new Object();

    public static void main(String[] args) {
        Runnable runnable = ()->{
            synchronized (MONITOR) {
                try {
                    Thread.sleep(200_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
    }
}
