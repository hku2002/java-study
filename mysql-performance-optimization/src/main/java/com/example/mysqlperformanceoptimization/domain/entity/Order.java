package com.example.mysqlperformanceoptimization.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long customerId;
    private LocalDate orderDate;
    private Long productId;
    private int quantity;
    private String status;

    @Builder
    public Order(Long orderId, Long customerId, LocalDate orderDate, Long productId, int quantity, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
    }
}
