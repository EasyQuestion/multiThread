package com.company.v1.chapter9;

import java.util.stream.Stream;

public class DifferenceOfWaitAndSleep {

    public static void main(String[] args) {
//        m1();
//        m2();

        Stream.of("t1","t2").forEach(n->
                new Thread(()->{
                    m2();//m1();
                },n).start());
    }

    static void m1(){
        try {
            synchronized (lock) {//sleep并不会释放锁资源
                System.out.println(Thread.currentThread().getName() + " start.");
                Thread.sleep(10_000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //IllegalMonitorStateException
    //wait必须与synchronized一起用
    private static Object lock = new Object();
    static void m2(){
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " start.");
                lock.wait();//wait会释放锁资源
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
