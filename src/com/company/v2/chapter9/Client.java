package com.company.v2.chapter9;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        RequestQueue queue = new RequestQueue();
        new CreatorThread(queue,"Alex").start();
        ConsumerThread consumerThread = new ConsumerThread(queue);
        consumerThread.start();

        Thread.sleep(10_000);
        System.out.println("close consumer");
        consumerThread.close();

    }
}
