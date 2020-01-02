package com.company.v2.chapter2;

import java.util.Optional;
import java.util.stream.IntStream;

public class WaitSet {

    private final static Object lock = new Object();

    /**
     * 1.所有对象都会有一个wait set,用来存放调用了该对象的wait方法之后进入block状态的线程
     * 2.线程被notify之后，不一定立即得到执行
     * 3.线程从wait set中被唤醒顺序不一定是fifo
     * 4.线程被唤醒后，必须重新获取锁
     * @param args
     * @throws InterruptedException
     */
    /*public static void main(String[] args) throws InterruptedException {
        IntStream.rangeClosed(1,10).forEach(n->new Thread(()->{
            synchronized (lock){
                try {
                    Optional.of(Thread.currentThread().getName()+" start to wait.").ifPresent(System.out::println);
                    lock.wait();
                    Optional.of(Thread.currentThread().getName()+" end to wait.").ifPresent(System.out::println);
                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },n+"").start());

        Thread.sleep(3_000);

        IntStream.rangeClosed(1,10).forEach(n->{
            synchronized (lock){
                lock.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }*/

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            work();
        }).start();

        Thread.sleep(1000);

        synchronized (lock){
            lock.notify();
        }
    }

    private static void work(){
        synchronized (lock){
            Optional.of("Begin...").ifPresent(System.out::println);
            try {
                Optional.of(Thread.currentThread().getName()+" start to wait.").ifPresent(System.out::println);
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Optional.of(Thread.currentThread().getName()+" end to wait.").ifPresent(System.out::println);
        }
    }
}
