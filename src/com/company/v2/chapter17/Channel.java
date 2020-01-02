package com.company.v2.chapter17;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.Arrays;

public class Channel {

    private static final int MAX_REQUEST_SIZE = 10;

    private int count;
    private int head;
    private int tail;

    private final Request[] requestQueue;
    private final WorkerThread[] workers;

    public Channel(int workerSize) {
        this.count = 0;
        this.head = 0;
        this.tail = 0;
        this.requestQueue = new Request[MAX_REQUEST_SIZE];
        this.workers = new WorkerThread[workerSize];

        init();
    }

    private void init() {
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    public void startWork() {
        Arrays.asList(workers).forEach(WorkerThread::start);
    }

    public synchronized void put(Request request) {
        while (count >= requestQueue.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        this.notifyAll();
    }

    public synchronized Request take() {
        while (count <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}
