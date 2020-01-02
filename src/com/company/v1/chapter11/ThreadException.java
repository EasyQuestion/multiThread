package com.company.v1.chapter11;

public class ThreadException {

    /*private static int A = 12;
    private static int B = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            int result = A/B;
            System.out.println(result);
        });

        t1.setUncaughtExceptionHandler((thread,e)->{
            System.out.println(thread.getName());
            System.out.println(e);
        });

        t1.start();
    }*/


    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.test();
    }
}
