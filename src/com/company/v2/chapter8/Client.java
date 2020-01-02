package com.company.v2.chapter8;

/**
 * Future   装结果的容器，先返回这个容器，随后从这个容器中拿结果
 * FutureTask  将业务逻辑进行隔离(真正干活的类)
 * FutureService  格拉FutureTask和Future
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        Future future = futureService.submit(()->{
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Finish.";
        });
        System.out.println("*******************");
        System.out.println("Do other thing.");
        Thread.sleep(1000);
        System.out.println("*******************");

        System.out.println(future.get());

    }
}
