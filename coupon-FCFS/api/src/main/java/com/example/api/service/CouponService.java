package com.example.api.service;

import com.example.api.infra.CouponCountRedisRepository;
import com.example.api.producer.CouponCreateProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponCountRedisRepository couponCountRedisRepository;
    private final CouponCreateProducer couponCreateProducer;

    public void apply(Long userId) {
        long count = couponCountRedisRepository.increment();

        if (count > 100) {
            return;
        }

        couponCreateProducer.create(userId);
    }

}
