package com.company.v2.chapter10;

import java.util.Random;

public class ComplexThreadLocalTest {

    //    private final static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private final static ThreadLocalSimulator<String> threadLocal = new ThreadLocalSimulator<String>() {
        @Override
        protected String initValue() {
            return "no value.";
        }
    };

    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                threadLocal.set(Thread.currentThread().getName());
                try {
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(Thread.currentThread().getName() + "  " + threadLocal.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable, "Thread-t1");
        Thread t2 = new Thread(runnable, "Thread-t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("===============================");
        System.out.println(threadLocal.get());
    }
}
