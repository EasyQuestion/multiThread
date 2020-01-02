package com.company.v2.chapter1;

import java.util.stream.IntStream;

//饱汉模式
//枚举类型实现单例模式
public class SingletonObject7 {

    private SingletonObject7() {
    }

    public static SingletonObject7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private final SingletonObject7 instance;

        Singleton() {
            instance = new SingletonObject7();
        }

        public SingletonObject7 getInstance() {
            return instance;
        }
    }


    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).forEach(i->new Thread(i+""){
            @Override
            public void run() {
                System.out.println(SingletonObject7.getInstance());
            }
        }.start());
    }

}
