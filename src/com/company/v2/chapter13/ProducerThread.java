package com.company.v2.chapter13;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerThread extends Thread {

    private final MessageQueue queue;
    private final Random random = new Random(System.currentTimeMillis());

    private static final AtomicInteger seq = new AtomicInteger(0);

    public ProducerThread(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                String message = "value-"+seq.getAndIncrement();
                queue.put(new Message(message));
                System.out.println(Thread.currentThread().getName()+"put message:"+message);
//                Thread.sleep(random.nextInt(1000));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
