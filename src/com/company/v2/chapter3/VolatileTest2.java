package com.company.v2.chapter3;

public class VolatileTest2 {

    private volatile static int initValue = 0;
    private static final int maxLimit = 5;

    public static void main(String[] args) {
        Runnable runnable = ()->{
            while(initValue<maxLimit){
                System.out.println(Thread.currentThread().getName()+"->"+(++initValue));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnable,"t1").start();
        new Thread(runnable,"t2").start();
    }
}
