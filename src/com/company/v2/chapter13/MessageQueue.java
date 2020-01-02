package com.company.v2.chapter13;

import java.util.LinkedList;

public class MessageQueue {
    private final LinkedList<Message> queue = new LinkedList<>();
    private final static int DEFAULT_MAX_LIMIT = 200;
    private final int limit;

    public MessageQueue(){
        this(DEFAULT_MAX_LIMIT);
    }

    public MessageQueue(int limit) {
        this.limit = limit;
    }

    public void put(Message message) throws InterruptedException {
        synchronized (queue){
            while (queue.size() > limit){
                queue.wait();
            }

            queue.addLast(message);
            queue.notifyAll();
        }
    }

    public Message take() throws InterruptedException {
        synchronized (queue){
            while (queue.isEmpty()){
                queue.wait();
            }
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }
}
