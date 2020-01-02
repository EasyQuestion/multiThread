package com.company.v1.chapter9;

import java.util.stream.Stream;

public class ProduceConsumeVersion {

    private int i;
    private volatile boolean flag = true;
    private final Object lock = new Object();

    public void produce() {
        synchronized (lock) {
            if (flag) {
                System.out.println("P->" + (i++));
                flag = false;
                lock.notifyAll();//lock.notify();
            } else {
//                System.out.println(Thread.currentThread().getName() + "produce waiting.");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consume() {
        synchronized (lock) {
            if (!flag) {
                System.out.println("C->" + i);
                flag = true;
                lock.notifyAll();//lock.notify();
            } else {
//                System.out.println(Thread.currentThread().getName() + "consume waiting");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumeVersion pcv = new ProduceConsumeVersion();

        Stream.of("p1", "p2").forEach(n ->
                new Thread(() -> {
                    while (true) {
                        pcv.produce();
                    }
                }).start()
        );

        Stream.of("c1", "c2").forEach(n ->
                new Thread(() -> {
                    while (true) {
                        pcv.consume();
                    }
                }).start()
        );

    }
}
