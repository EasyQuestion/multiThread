package com.company.v2.chapter4.threadObserver;

import java.util.List;

public class ThreadLifeCycleListener implements ThreadListener {

    final private Object LOCK = new Object();

    @Override
    public void update(ThreadObserver.Event event) {
        synchronized (LOCK) {
            System.out.println("The current thread[" + event.getThread().getName() + "] state is " + event.getState());
            if (event.getError() != null) {
                event.getError().printStackTrace();
            }
        }
    }

    public void concurrentQuery(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return;
        }

        ids.stream().forEach(id -> new Thread(new ThreadObserver(this) {
            @Override
            public void run() {
                try {
                    notify(new Event(Thread.currentThread(), ThreadState.RUNNING, null));
                    System.out.println(Thread.currentThread().getName() + " get id:" + id);
//                    int i = 1/0;
                    Thread.sleep(10_000);
                    notify(new Event(Thread.currentThread(), ThreadState.DONE, null));
                } catch (Exception e) {
                    notify(new Event(Thread.currentThread(), ThreadState.ERROR, e));
                }
            }
        }).start());
    }
}
