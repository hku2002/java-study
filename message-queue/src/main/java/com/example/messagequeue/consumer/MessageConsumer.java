package com.example.messagequeue.consumer;

import com.example.messagequeue.queue.Message;

import java.util.List;

public interface MessageConsumer {

    Message consumeOne();

    List<Message> consumeBatch(int batchSize);

}
