package com.company.v2.chapter12;

import java.io.IOException;
import java.util.Random;

public class ConsumerThread extends Thread {

    private final BalkingData balkingData;
    private final Random random = new Random(System.currentTimeMillis());

    public ConsumerThread(BalkingData balkingData) {
        super("Consumer");
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        try {
            balkingData.save();
            for (int i = 0; i < 5; i++) {
                balkingData.change("No." + i);
                Thread.sleep(random.nextInt(1000));
                balkingData.save();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
