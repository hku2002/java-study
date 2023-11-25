package com.example.api.service;

import com.example.api.infra.RedisRepository;
import com.example.api.producer.CouponCreateProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final RedisRepository couponCountRedisRepository;
    private final CouponCreateProducer couponCreateProducer;

    public void apply(Long userId) {
        Long apply = couponCountRedisRepository.set(String.valueOf(userId));
        if (apply != 1) {
            return;
        }

        long count = couponCountRedisRepository.increment();
        if (count > 100) {
            return;
        }

        couponCreateProducer.create(userId);
    }

}
