package com.example.api.service;

import com.example.api.domain.entity.Coupon;
import com.example.api.domain.repository.CouponRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @Test
    @DisplayName("동시에 1000명 쿠폰 발급 시 100명만 발급 되어야한다.")
    void apply100Coupon() throws InterruptedException {
        // given
        int threadCount = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        // when
        for (int i=0; i<threadCount; i++) {
            long userId = i;
            executorService.submit(() -> {
                couponService.apply(userId);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        // then
        long count = couponRepository.count();
        assertThat(count).isEqualTo(100);

    }

}