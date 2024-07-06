package com.example.messagequeue.queue;

public interface MessageQueue {

    boolean add(Message message);

    Message poll();

    int getTotalSize();

}
