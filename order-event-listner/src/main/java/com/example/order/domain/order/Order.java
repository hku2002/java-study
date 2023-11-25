package com.example.order.domain.order;

import com.example.order.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderName;
    private int totalPrice;

    @Builder
    public Order(String orderName, int totalPrice) {
        this.orderName = orderName;
        this.totalPrice = totalPrice;
    }
}
