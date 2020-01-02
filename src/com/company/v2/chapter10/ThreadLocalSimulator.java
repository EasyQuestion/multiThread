package com.company.v2.chapter10;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalSimulator<T> {

    private final Map<Thread,T> storage = new HashMap<>();


    public void set(T t){
        synchronized (this){
            Thread key = Thread.currentThread();
            storage.put(key,t);
        }
    }

    public T get(){
        synchronized (this){
            Thread key = Thread.currentThread();
            T t = storage.get(key);
            if(t == null){
                return initValue();
            }
            return t;
        }
    }

    protected T initValue() {
        return null;
    }
}
