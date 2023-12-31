package com.example.order.domain.order;

import com.example.order.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProduct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String productName;
    private int price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @Builder
    public OrderProduct(String productName, Long productId, int price, Order order) {
        this.productName = productName;
        this.productId = productId;
        this.price = price;
        this.order = order;
    }

    public void addOrder(Order order) {
        this.order = order;
    }
}
