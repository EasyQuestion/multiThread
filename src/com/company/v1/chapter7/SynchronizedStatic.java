package com.company.v1.chapter7;

public class SynchronizedStatic {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            StaticLock.m1();
        });
        Thread t2 = new Thread(() -> {
            StaticLock.m2();
        });
        Thread t3 = new Thread(() -> {
            StaticLock.m3();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}

class StaticLock {

    static {
        synchronized (ThisLock.class) {
            System.out.println("static  " + Thread.currentThread().getName());
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m3() {
        System.out.println(Thread.currentThread().getName() + "-m3");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void m1() {
        System.out.println(Thread.currentThread().getName() + "-m1");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void m2() {
        System.out.println(Thread.currentThread().getName() + "-m2");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

