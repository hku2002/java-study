package com.example.messagequeue.api;

import com.example.messagequeue.producer.MessageProducer;
import com.example.messagequeue.queue.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddQueueApi {

    private final MessageProducer messageProducer;


    @PostMapping("/queue")
    public boolean sendMessage(@RequestBody Message message) {
        return messageProducer.sendOne(message);
    }

}
