package com.example.messagequeue.queue;

import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class CustomMessageQueue implements MessageQueue {

    private final Queue<Message> queue = new ConcurrentLinkedQueue<>();

    @Override
    public boolean add(Message message) {
        return queue.add(message);
    }

    @Override
    public Message poll() {
        return queue.poll();
    }

    @Override
    public int getTotalSize() {
        return queue.size();
    }
}
