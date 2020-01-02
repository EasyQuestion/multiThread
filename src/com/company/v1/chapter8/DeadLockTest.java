package com.company.v1.chapter8;

public class DeadLockTest {

    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    deadLock.m1();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    otherService.f1();
                }
            }
        }.start();
    }
}
