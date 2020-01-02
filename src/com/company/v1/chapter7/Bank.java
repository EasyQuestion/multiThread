package com.company.v1.chapter7;

public class Bank {
    public static void main(String[] args) {
        WindowCheck2 windowCheck = new WindowCheck2();
        Thread t1 = new Thread(windowCheck);
        Thread t2 = new Thread(windowCheck);
        Thread t3 = new Thread(windowCheck);

        t1.start();
        t2.start();
        t3.start();
    }
}
