package com.company.v1.chapter5;

public class ThreadJoin2 {

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable(1000,"machine1"));
        Thread t2 = new Thread(new CaptureRunnable(3000,"machine2"));
        Thread t3 = new Thread(new CaptureRunnable(1500,"machine3"));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.printf("spend time:[%s]\n",(System.currentTimeMillis()-startTime));

    }
}

class CaptureRunnable implements Runnable{

    private long spendTime;

    private String machineName;

    public CaptureRunnable(long spendTime, String machineName) {
        this.spendTime = spendTime;
        this.machineName = machineName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.println(machineName+" finish data capture and successfully in "+spendTime+" ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
