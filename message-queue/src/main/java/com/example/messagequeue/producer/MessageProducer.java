package com.example.messagequeue.producer;

import com.example.messagequeue.queue.Message;

import java.util.List;

public interface MessageProducer {

    boolean sendOne(Message message);

    int sendBatch(List<Message> messages);

}
