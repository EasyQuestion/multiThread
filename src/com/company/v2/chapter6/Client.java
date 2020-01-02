package com.company.v2.chapter6;

public class Client {

    public static void main(String[] args) {
        final SharedData data = new SharedData(10);
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new WriterWorker(data,"qwerttyuiopasdfg").start();
        new WriterWorker(data,"QWERTTYUIOPASDFG").start();
    }
}
