package com.company.v2.chapter3;

public class VolatileEntity {
    private boolean flag = true;

    public void work(){
        while (true){
            if(flag) {
                System.out.println("the flag is true |" + System.currentTimeMillis());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void change(){
        while (true){
            flag = !flag;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
