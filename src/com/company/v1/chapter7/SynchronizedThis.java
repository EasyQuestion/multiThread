package com.company.v1.chapter7;

public class SynchronizedThis {

    public static void main(String[] args) {
        ThisLock lock = new ThisLock();
        Thread t1 = new Thread(()->{
            lock.m1();
        });
        Thread t2 = new Thread(()->{
            lock.m2();
        });

        t1.start();
        t2.start();
    }

}

class ThisLock{

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+"-m1");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m2(){
        System.out.println(Thread.currentThread().getName()+"-m2");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
