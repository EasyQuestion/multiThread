package com.company.v2.chapter13;

public class Client {

    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        new ProducerThread(queue).start();
        new ProducerThread(queue).start();
        new ProducerThread(queue).start();
        new ConsumerThread(queue).start();
        new ConsumerThread(queue).start();
    }
}
