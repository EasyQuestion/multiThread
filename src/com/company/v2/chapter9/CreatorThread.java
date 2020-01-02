package com.company.v2.chapter9;

import java.util.Random;

public class CreatorThread extends Thread {

    private final RequestQueue queue;
    private final String name;

    private final Random random;

    public CreatorThread(RequestQueue queue, String name) {
        this.queue = queue;
        this.name = name;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("add request_"+i+":" + name);
            queue.setRequest(new Request(name));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
