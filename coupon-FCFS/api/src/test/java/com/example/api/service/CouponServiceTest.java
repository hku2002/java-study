package com.example.api.service;

import com.example.api.domain.entity.Coupon;
import com.example.api.domain.repository.CouponRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CouponServiceTest {

    @Autowired
    CouponRepository couponRepository;

    @Autowired
    CouponService couponService;

    @AfterEach
    void afterEach() {
        couponRepository.deleteAll();
    }

    @Test
    @DisplayName("쿠폰 한번 발급 요청 시 올바르게 발급된다.")
    void applyCouponSuccess() {

        // when
        couponService.apply(1L);

        // then
        Coupon coupon = couponRepository.findById(1L).orElseThrow();
        assertThat(coupon.getUserId()).isEqualTo(1L);
    }

}