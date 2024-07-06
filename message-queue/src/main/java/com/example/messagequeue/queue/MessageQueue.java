package com.example.messagequeue.queue;

public interface MessageQueue {

    void add(Message message);

    Message poll();

    int getTotalSize();

}
