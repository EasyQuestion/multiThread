package com.company.v2.chapter6;

public class ReadWriteLock {

    private int readingNum = 0;
    private int readWaiting = 0;
    private int writingNum = 0;
    private int writeWaiting = 0;

    private boolean preferWriter;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    public synchronized void readLock() throws InterruptedException {
        readWaiting++;
        try {
            while (writingNum > 0 || (preferWriter && writeWaiting > 0)) {
                this.wait();
            }
            readingNum++;
        } finally {
            readWaiting--;
        }
    }

    public synchronized void readUnLock() {
        readingNum--;
        this.notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        writeWaiting++;
        try {
            while (writingNum > 0 || readingNum > 0) {
                this.wait();
            }
            writingNum++;
        } finally {
            writeWaiting--;
        }
    }

    public synchronized void writeUnLock() {
        writingNum--;
        this.notifyAll();
    }
}
