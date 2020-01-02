package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    static ConcurrentHashMap chm = new ConcurrentHashMap();

    public static void main(String[] args) {

        //并发安全集合（2种）
        //一种：ConcurrentHashMap
        //另一种：将线程不安全的map转变成线程安全的
//        Collections.synchronizedMap(new HashMap());

        for(int i=0;i<1000;i++) {
            chm.put("key"+i,i);
        }
        System.out.println("Hello World!");
    }

    /*public static void main(String[] args) {
        *//*int n = -20;
//        n = n - (n >>> 2);
        System.out.println((n >> 2));*//*

        int a;
        int b;
        a=b=12;
        System.out.println(a);
        System.out.println(b);
    }*/


    //Thread.yield(); 给其他线程一些运行的机会，避免一个线程长时间占有 CPU 资源
    /***yield 和 sleep 的异同
     * 1）yield, sleep 都能暂停当前线程，sleep 可以指定具体休眠的时间，而 yield 则依赖 CPU 的时间片划分。
     * 2）yield, sleep 两个在暂停过程中，如已经持有锁，则都不会释放锁资源。
     * 3）yield 不能被中断，而 sleep 则可以接受中断。
     */
    /*public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<=100;i++){
                    System.out.println(Thread.currentThread().getName()+"-----"+i);
                    if(i %20 == 0){
                        Thread.yield();
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable,"栈长");
        Thread thread2 = new Thread(runnable,"小密");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }*/

}
