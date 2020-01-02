package com.company.v1.chapter6;

public class ThreadStopGraceful {

    /*private static class App implements Runnable{

        private volatile boolean start = true;
        @Override
        public void run() {
            while(start){
                System.out.println("is running.");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown(){
            this.start = false;
            System.out.println("shutdown.");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        new Thread(app).start();
        Thread.sleep(1000);
        app.shutdown();
    }*/


    private static class Worker extends Thread {

        private volatile boolean start = true;

        @Override
        public void run() {
            while (start) {
                System.out.println("is running.");
            }
        }

        public void shutdown() {
            this.start = false;
            System.out.println("shutdown.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(1000);
        worker.shutdown();
    }
}
