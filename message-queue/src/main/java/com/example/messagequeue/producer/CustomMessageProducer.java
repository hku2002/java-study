package com.example.messagequeue.producer;

import com.example.messagequeue.queue.Message;
import com.example.messagequeue.queue.MessageQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomMessageProducer implements MessageProducer {

    private final MessageQueue messageQueue;

    @Override
    public boolean send(Message message) {
        return messageQueue.add(message);
    }

}
