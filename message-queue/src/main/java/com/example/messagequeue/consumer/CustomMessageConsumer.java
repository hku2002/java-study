package com.example.messagequeue.consumer;

import com.example.messagequeue.queue.Message;
import com.example.messagequeue.queue.MessageQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class CustomMessageConsumer implements MessageConsumer {

    private final MessageQueue messageQueue;

    @Override
    public Message consumeOne() {
        return messageQueue.poll();
    }

    @Override
    public List<Message> consumeBatch(int batchSize) {
        List<Message> messages = new LinkedList<>();
        IntStream.range(0, batchSize)
                .forEach(i -> messages.add(messageQueue.poll()));
        return messages;
    }
}
