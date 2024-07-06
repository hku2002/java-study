package com.example.messagequeue.producer;

import com.example.messagequeue.queue.Message;

public interface MessageProducer {

    boolean send(Message message);

}
