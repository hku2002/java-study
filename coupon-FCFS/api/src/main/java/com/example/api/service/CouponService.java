package com.example.api.service;

import com.example.api.domain.entity.Coupon;
import com.example.api.domain.repository.CouponRepository;
import com.example.api.infra.CouponCountRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final CouponCountRedisRepository couponCountRedisRepository;

    public void apply(Long userId) {
        long count = couponCountRedisRepository.increment();

        if (count > 100) {
            return;
        }

        couponRepository.save(Coupon.createCoupon(userId, "선착순 쿠폰"));
    }

}
