package com.company.v1.chapter8;

public class DeadLock {

    private final Object lock = new Object();

    private OtherService otherService;

    public DeadLock(OtherService otherService) {
        this.otherService = otherService;
    }

    public void m1(){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"-m1");
            otherService.f1();
        }
    }
}
