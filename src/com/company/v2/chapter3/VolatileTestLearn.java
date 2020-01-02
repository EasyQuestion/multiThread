package com.company.v2.chapter3;

public class VolatileTestLearn {

    /*public static void main(String[] args) {
        VolatileEntity entity = new VolatileEntity();
        new Thread(()->{
            entity.work();
        }).start();

        new Thread(()->{
            entity.change();
        }).start();
    }*/

//==============================================================
    /*public static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
                while (flag) {
                }
                System.out.println(Thread.currentThread().getName() + "线程停止，死循环被打开");
            }).start();

        new Thread(()-> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = false;
                System.out.println(Thread.currentThread().getName() + "修改 flag 为" + flag);
            }).start();

//        Thread.sleep(Integer.MAX_VALUE);
    }*/


    //=====================================================================================
    public static void main(String[] args) throws InterruptedException {
        MyThread<Integer> t = new MyThread<Integer>();

        System.out.println("开始执行！！！！！！！！！！！");

        new Thread(t).start();

        int s = t.get();

        System.out.println("执行结果" + s);
    }
}
