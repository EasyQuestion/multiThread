package com.company.v1.chapter5;

public class ThreadInterrupt {

    /*public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while(true){
                System.out.println(">>"+Thread.currentThread().isInterrupted());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("清空打断标记");//修改成默认值false
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        Thread.sleep(1000);
        System.out.println(t1.isInterrupted());
        t1.interrupt();
        System.out.println(t1.isInterrupted());
    }*/


    /*private final static Object MONITOR = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    try {
//                        System.out.println(">>"+Thread.interrupted());//false
                        System.out.println(">>"+Thread.currentThread().isInterrupted());//false
                        MONITOR.wait(10);
                    } catch (InterruptedException e) {
                        System.out.println("清空打断标记");//修改成默认值false
                        e.printStackTrace();
                    }
                }

            }
        });

        t1.start();
        Thread.sleep(1000);

        System.out.println(t1.isInterrupted());
        t1.interrupt();
        System.out.println(t1.isInterrupted());
    }*/


    //join + interrupt  实现清空打断标识并报错 InterruptedException
    public static void main(String[] args){
        Thread t1 = new Thread(()->{
            while (true){
//                System.err.println(">>"+Thread.interrupted());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });

        t1.start();

        Thread.currentThread().interrupt();
        try {
            t1.join();
        } catch (InterruptedException e) {
//            t1.interrupt();
            e.printStackTrace();
        }


    }


    /*public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(()->{
            while(true){

            }
        });

        Thread main = Thread.currentThread();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 start.");
            main.interrupt();
            System.out.println("t2 end.");
        });

        t1.start();
        t2.start();

        t1.join();
    }*/
}
