package com.company.v2.chapter11.demo2;

public class Client {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            try {
                UserContext context = new UserContext(Thread.currentThread().getName());
                Thread.sleep(10_000);
                System.out.println(Thread.currentThread().getName()+"->"+UserContext.get());
                context.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }

        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
