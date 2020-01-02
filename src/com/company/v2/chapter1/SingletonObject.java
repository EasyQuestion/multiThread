package com.company.v2.chapter1;

//饿汉模式
public class SingletonObject {

    private static final SingletonObject instance = new SingletonObject();

    private SingletonObject() {
    }

    public static SingletonObject getInstance(){
        return instance;
    }
}
