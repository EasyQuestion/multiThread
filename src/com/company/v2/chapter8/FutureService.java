package com.company.v2.chapter8;

public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task){
        AsyncFuture<T> future = new AsyncFuture<>();
        new Thread(()->{
            T result = task.call();
            future.done(result);
        }).start();
        return future;
    }
}
