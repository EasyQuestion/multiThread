package com.company.v2.chapter11.demo2;

public class UserContext implements AutoCloseable {

    private static final ThreadLocal<String> context = new ThreadLocal<>();

    public UserContext(String name) {
        this.context.set(name);
    }

    public static String get(){
        return context.get();
    }

    @Override
    public void close() throws Exception {
        context.remove();
    }
}
