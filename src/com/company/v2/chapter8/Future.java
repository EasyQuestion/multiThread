package com.company.v2.chapter8;

public interface Future<T> {

    T get()throws InterruptedException;
}
