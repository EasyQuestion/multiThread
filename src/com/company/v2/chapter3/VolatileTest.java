package com.company.v2.chapter3;

public class VolatileTest {

//    private volatile static int initValue = 0;
    private static int initValue = 0;
    private final static int maxLimit = 10;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = initValue;
            while (localValue < maxLimit) {
                if (localValue != initValue) {
                    System.out.printf("the value update to [%d]\n", initValue);
                    localValue = initValue;
                }
            }
        }).start();

        new Thread(() -> {
            int localValue = initValue;
            while (initValue < maxLimit) {
                System.out.printf("update initValue to [%d]\n", ++localValue);
                initValue = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
