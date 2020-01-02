package com.company.v2.chapter13;

import java.util.Random;

public class ConsumerThread extends Thread {

    private final MessageQueue queue;
    private final Random random = new Random(System.currentTimeMillis());

    public ConsumerThread(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message message = queue.take();
                System.out.println(Thread.currentThread().getName()+"take message:"+message.getValue());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
