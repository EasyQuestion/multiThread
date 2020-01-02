package com.company.v2.chapter1;

//饱汉模式
//内部类Holder实现单例模式
public class SingletonObject6 {

    private SingletonObject6() {
    }

    public static SingletonObject6 getInstance(){
        return InstanceHolder.instance;
    }

    //内部类Holder
    //线程安全的，JVM只会加载一次
    private static class InstanceHolder{
        private static final SingletonObject6 instance = new SingletonObject6();
    }
}
