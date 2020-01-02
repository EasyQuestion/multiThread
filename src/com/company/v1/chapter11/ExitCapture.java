//package com.company.chapter11;

public class ExitCapture {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("The application will be exit.");

            System.out.println("notify to thd admin.");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("will release resource(socket,file.connection).");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        int i=0;

        while (true){
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            System.out.println("I am working...");

            i++;
            if(i >=20){
                throw new RuntimeException("error");
            }

        }
    }
}
