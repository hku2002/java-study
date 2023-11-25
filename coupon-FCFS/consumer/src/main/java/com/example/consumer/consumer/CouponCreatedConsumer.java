package com.example.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.example.consumer.config.KafkaConsumerConfig.GROUP_ID;

@Slf4j
@Component
public class CouponCreatedConsumer {

    @KafkaListener(topics = "coupon-FCFS", groupId = GROUP_ID)
    public void listener(Long userId) {
        log.info("userId : {}", userId);
    }
}
