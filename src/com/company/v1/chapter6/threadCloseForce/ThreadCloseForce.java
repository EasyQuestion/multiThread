package com.company.v1.chapter6.threadCloseForce;

public class ThreadCloseForce {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ThreadService service = new ThreadService();
        service.execute(()->{
            /*while(true){
                //load a heavy resource.
            }*/

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.shutdown(1000);

        System.out.println((System.currentTimeMillis()-start));
    }
}
