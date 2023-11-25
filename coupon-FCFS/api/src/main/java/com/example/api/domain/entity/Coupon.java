package com.example.api.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String couponName;

    @Builder
    public Coupon(Long userId, String couponName) {
        this.userId = userId;
        this.couponName = couponName;
    }

    public static Coupon createCoupon(Long userId, String couponName) {
        return Coupon.builder()
                .userId(userId)
                .couponName(couponName)
                .build();
    }
}
