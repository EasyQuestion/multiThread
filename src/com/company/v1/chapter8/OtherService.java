package com.company.v1.chapter8;

public class OtherService {

    private DeadLock deadLock;

    private final Object lock = new Object();

    public void f1() {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"==============f1");
            deadLock.m1();
        }
    }

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }
}
