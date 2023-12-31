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

        /* consumer에서 소비하는 시간이 있기에 10초 기다림 */
        Thread.sleep(10000L);

        // then
        long count = couponRepository.count();
        assertThat(count).isEqualTo(100);

    }

    @Test
    @DisplayName("1명당 1개의 쿠폰만 발급되어야 한다.")
    void applyOneUser() throws InterruptedException {
        // given
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        // when
        for (int i=0; i<threadCount; i++) {
            long userId = 1L;
            executorService.submit(() -> {
                couponService.apply(userId);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        /* consumer에서 소비하는 시간이 있기에 5초 기다림 */
        Thread.sleep(5000L);

        // then
        long count = couponRepository.count();
        assertThat(count).isEqualTo(1);

    }

}