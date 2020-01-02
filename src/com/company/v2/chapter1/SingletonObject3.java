package com.company.v2.chapter1;

//饱汉模式
public class SingletonObject3 {

    private static SingletonObject3 instance;

    private SingletonObject3() {
    }

    public synchronized static SingletonObject3 getInstance(){
        if(instance == null){
            instance = new SingletonObject3();
        }
        return instance;
    }
}
