package com.company.v1.chapter12;

import java.util.Arrays;

public class ThreadGroupCreate {

    public static void main(String[] args) {
        /*new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getThreadGroup().getName());
        }).start();*/

        ThreadGroup tg1 = new ThreadGroup("tg1");
        Thread t1 = new Thread(tg1,"t1"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getThreadGroup().getName());
                System.out.println(Thread.currentThread().getThreadGroup().activeCount());
                System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
                int num = Thread.currentThread().getThreadGroup().getParent().activeCount();
                Thread[] threads = new Thread[num];
                Thread.currentThread().getThreadGroup().getParent().enumerate(threads);
                Arrays.asList(threads).forEach(System.out::println);
            }
        };
        t1.start();
    }
}
