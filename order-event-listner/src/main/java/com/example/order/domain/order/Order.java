package com.example.order.domain.order;

import com.example.order.common.entity.BaseEntity;
import com.example.order.domain.order.enumtype.OrderStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.example.order.domain.order.enumtype.OrderStatus.COMPLETE;
import static com.example.order.domain.order.enumtype.OrderStatus.READY;

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
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Builder
    public Order(String orderName, int totalPrice, OrderStatus status, List<OrderProduct> orderProducts) {
        this.orderName = orderName;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderProducts = orderProducts;
    }

    public void completeStatus() {
        if (!this.status.equals(READY)) {
            throw new IllegalStateException("주문 완료 불가능한 상태입니다.");
        }
        this.status = COMPLETE;
    }
}
