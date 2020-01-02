package com.company.v1.chapter5;

public class ThreadJoin {

    /*public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            IntStream.range(1,1000)
                    .forEach(i-> System.out.println(Thread.currentThread().getName()+"->"+i));
        });

        Thread t2 = new Thread(()->{
            IntStream.range(1,1000)
                    .forEach(i-> System.out.println(Thread.currentThread().getName()+"->"+i));
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Optional.of("all thread are finished.").ifPresent(System.out::println);

        IntStream.range(1,1000)
                .forEach(i-> System.out.println(Thread.currentThread().getName()+"->"+i));
    }*/

    /*public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(10_000);
                System.out.println("t1 is finished.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t1.join(100);

        Optional.of("all thread are finished.").ifPresent(System.out::println);

        IntStream.range(1,1000)
                .forEach(i-> System.out.println(Thread.currentThread().getName()+"->"+i));
    }*/

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
    }
}
