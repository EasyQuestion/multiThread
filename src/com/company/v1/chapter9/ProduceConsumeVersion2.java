package com.company.v1.chapter9;

import java.util.stream.Stream;

public class ProduceConsumeVersion2 {

    private int i;
    private volatile boolean flag = true;
    private final Object lock = new Object();

    public void produce() {
        synchronized (lock) {
            while (!flag) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("P->" + (i++));
            flag = false;
            lock.notifyAll();//lock.notify();
        }
    }

    public void consume() {
        synchronized (lock) {
            while (flag) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C->" + i);
            flag = true;
            lock.notifyAll();//lock.notify();
        }
    }

    public static void main(String[] args) {
        ProduceConsumeVersion2 pcv = new ProduceConsumeVersion2();

        Stream.of("p1", "p2", "p3").forEach(n ->
                new Thread(() -> {
                    while (true) {
                        pcv.produce();
                    }
                }).start()
        );

        Stream.of("c1", "c2", "c3", "c4").forEach(n ->
                new Thread(() -> {
                    while (true) {
                        pcv.consume();
                    }
                }).start()
        );

    }
}
