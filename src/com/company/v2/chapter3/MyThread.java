package com.company.v2.chapter3;

public class MyThread<V> implements Runnable {
    // 返回值
    public int v;

    // 是否结束标示位
    public int flag = 0;

    @Override
    public void run() {
        int result = 0;

        for (int j = 0; j <= 5; j++) {
            System.out.println("第" + j + "个");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            result += j;
        }

        // 执行完置标示位
        flag = 1;

        // 返回值赋值
        v = result;
    }

    // 获取执行结果方法
    public int get() throws InterruptedException {
        while (true) {
            if (this.flag == 1) {
                System.out.println("执行完毕");

                break;
            }
        }

        return v;
    }

}
