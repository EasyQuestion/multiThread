package com.company.v2.chapter7;

public class ImmutableTest {

    public static void main(String[] args) throws InterruptedException {

        Long start = System.currentTimeMillis();
//        7348  13773
        ImmutableObj obj = new ImmutableObj("Alex");
//        6336  14443
//        SyncObj obj = new SyncObj();
//        obj.setName("Alex");

        Runnable runnable = ()-> {
            for (int i = 0; i < 1000000; i++) {
                System.out.println(obj);
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Long end = System.currentTimeMillis();
        System.out.println("spend time:" + (end - start));
    }
}


final class ImmutableObj {
    private final String name;

    public ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}

class SyncObj {
    private String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        return "[" + name + "]";
    }
}