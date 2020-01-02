package com.company.v2.chapter1;

//饱汉模式
public class SingletonObject4 {

    private static SingletonObject4 instance;

    private SingletonObject4() {
    }

    //double check
    public static SingletonObject4 getInstance(){
        if(instance == null){
            synchronized (SingletonObject4.class){
                if(instance == null){
                    instance = new SingletonObject4();
                }
            }

        }
        return instance;
    }
}
