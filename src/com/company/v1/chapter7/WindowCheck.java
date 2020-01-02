package com.company.v1.chapter7;

public class WindowCheck implements Runnable {

    private int i;

    private final static int MAX = 500;

    private final Object obj = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (obj) {
                if (i > MAX) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i++);
            }
        }
    }
}
