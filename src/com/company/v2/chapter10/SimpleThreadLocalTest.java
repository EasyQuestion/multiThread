package com.company.v2.chapter10;

public class SimpleThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return "Alex";
        }
    };

    public static void main(String[] args) throws InterruptedException {
//        threadLocal.set("Alex");
        Thread.sleep(2_000);
        String value = threadLocal.get();
        System.out.println(value);
    }
}
