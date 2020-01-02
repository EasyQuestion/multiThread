package com.company.v2.chapter9;

import java.util.Random;

public class ConsumerThread extends Thread {

    private final RequestQueue requestQueue;
    private final Random random;

    private volatile boolean closed = false;

    public ConsumerThread(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (!closed) {
            Request request = requestQueue.getRequest();
            if (request == null) {
                System.out.println("empty queue.");
                continue;
            }
            System.out.println("remove request:" + request.getValue());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }

    }

    public void close() {
        this.closed = true;
        this.interrupt();
    }
}
