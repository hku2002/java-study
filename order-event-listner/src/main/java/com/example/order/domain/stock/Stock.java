package com.example.order.domain.stock;

import com.example.order.common.entity.BaseEntity;
import com.example.order.domain.product.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stockName;
    private int quantity;

    @Builder
    public Stock(String stockName, int quantity) {
        this.stockName = stockName;
        this.quantity = quantity;
    }
}
