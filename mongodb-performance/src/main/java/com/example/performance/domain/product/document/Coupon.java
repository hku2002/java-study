package com.example.performance.domain.product.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Getter
@NoArgsConstructor
public class Coupon {

    @Field("isIssued")
    private boolean isIssued;

    @Field("userBitmap")
    private String userBitmap;

    public Coupon(boolean isIssued, String userBitmap) {
        this.isIssued = isIssued;
        this.userBitmap = userBitmap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return isIssued == coupon.isIssued && Objects.equals(userBitmap, coupon.userBitmap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isIssued, userBitmap);
    }
}
