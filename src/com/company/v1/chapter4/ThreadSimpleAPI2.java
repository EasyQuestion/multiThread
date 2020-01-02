package com.company.v1.chapter4;

public class ThreadSimpleAPI2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i=0;i<1000;i++){
                System.out.println(Thread.currentThread().getName()+"-Index"+i);
            }
        },"t1");
        Thread t2 = new Thread(()->{
            for(int i=0;i<1000;i++){
                System.out.println(Thread.currentThread().getName()+"-Index"+i);
            }
        },"t2");
        Thread t3 = new Thread(()->{
            for(int i=0;i<1000;i++){
                System.out.println(Thread.currentThread().getName()+"-Index"+i);
            }
        },"t3");


        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
