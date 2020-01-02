package com.company.v2.chapter1;

//饱汉模式
//volatile防止空指针异常
public class SingletonObject5 {

    private volatile static SingletonObject5 instance;

    private SingletonObject5() {
    }

    //double check
    public static SingletonObject5 getInstance(){
        if(instance == null){
            synchronized (SingletonObject5.class){
                if(instance == null){
                    instance = new SingletonObject5();
                }
            }

        }
        return instance;
    }
}
