package com.example.order.domain.order;

import com.example.order.common.entity.BaseEntity;
import com.example.order.domain.order.enumtype.OrderStatus;
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
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Builder
    public Order(String orderName, int totalPrice, OrderStatus status) {
        this.orderName = orderName;
        this.totalPrice = totalPrice;
        this.status = status;
    }
}
