package com.company.v2.chapter4.threadObserver;

public abstract class ThreadObserver implements Runnable {

    final protected ThreadListener listener;

    public ThreadObserver(final ThreadListener listener) {
        this.listener = listener;
    }

    protected void notify(final Event event) {
        listener.update(event);
    }

    public enum ThreadState {
        RUNNING, ERROR, DONE
    }

    public static class Event {
        final private Thread thread;
        final private ThreadState state;
        final private Throwable error;

        public Event(Thread thread, ThreadState state, Throwable error) {
            this.thread = thread;
            this.state = state;
            this.error = error;
        }

        public Thread getThread() {
            return thread;
        }

        public ThreadState getState() {
            return state;
        }

        public Throwable getError() {
            return error;
        }
    }
}
