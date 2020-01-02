package com.company.v1.chapter7;

public class WindowCheck2 implements Runnable {

    private int i;

    private final static int MAX = 500;

    @Override
    public void run() {
        while(!work()){

        }
    }

    private synchronized boolean work(){
        if (i > MAX) {
            return true;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + i++);
        return false;
    }
}
