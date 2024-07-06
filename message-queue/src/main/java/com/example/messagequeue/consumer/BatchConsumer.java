package com.example.messagequeue.consumer;

import com.example.messagequeue.queue.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BatchConsumer {

    private final MessageConsumer messageConsumer;

    @Scheduled(cron = "0/1 * * * * *")
    public void consume() {
        Message message = messageConsumer.consumeOne();
        log.info("메세지가 Consume 되었습니다.");
        log.info("메세지 정보: {}", message);
    }

}
