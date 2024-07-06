package com.example.messagequeue.producer;

import com.example.messagequeue.queue.Message;
import com.example.messagequeue.queue.MessageQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class CustomMessageProducer implements MessageProducer {

    private final MessageQueue messageQueue;

    @Override
    public boolean sendOne(Message message) {
        return messageQueue.add(message);
    }

    @Override
    public int sendBatch(List<Message> messages) {
        AtomicInteger successCount = new AtomicInteger(0);
        messages.forEach(message -> {
            boolean result = messageQueue.add(message);
            if (!result) return;
            successCount.incrementAndGet();
        });
        return successCount.get();
    }

}
