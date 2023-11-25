package com.example.consumer.consumer;

import com.example.consumer.domain.entity.Coupon;
import com.example.consumer.domain.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.example.consumer.config.KafkaConsumerConfig.GROUP_ID;

@Slf4j
@Component
@RequiredArgsConstructor
public class CouponCreatedConsumer {

    private final CouponRepository couponRepository;

    @KafkaListener(topics = "coupon-FCFS", groupId = GROUP_ID)
    public void listener(Long userId) {
        log.info("userId : {}", userId);
        Coupon coupon = Coupon.createCoupon(userId, "선착순 쿠폰");
        couponRepository.save(coupon);
    }
}
