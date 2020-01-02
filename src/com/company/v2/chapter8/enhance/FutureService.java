package com.company.v2.chapter8.enhance;

import com.company.v2.chapter8.AsyncFuture;
import com.company.v2.chapter8.Future;
import com.company.v2.chapter8.FutureTask;

import java.util.function.Consumer;

public class FutureService {

    public <T> void submit(final FutureTask<T> task, Consumer<T> consumer){
        AsyncFuture<T> future = new AsyncFuture<>();
        new Thread(()->{
            T result = task.call();
            consumer.accept(result);
        }).start();
    }
}
