package com.company.v2.chapter4.threadObserver;

import java.util.Arrays;

public class ThreadClient {

    public static void main(String[] args) {
        ThreadLifeCycleListener listener = new ThreadLifeCycleListener();
        listener.concurrentQuery(Arrays.asList("1","2","3"));
    }
}
