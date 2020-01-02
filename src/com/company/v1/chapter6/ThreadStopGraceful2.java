package com.company.v1.chapter6;

public class ThreadStopGraceful2 {
    private static class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("is interrupted.");
                    break;
                }
                System.out.println("is running.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(1000);
        worker.interrupt();
        System.out.println("begin interrupt.");
    }
}
