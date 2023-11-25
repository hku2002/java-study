package com.example.order.domain.product;

import com.example.order.common.entity.BaseEntity;
import com.example.order.domain.stock.Stock;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    @Builder
    public Product(String productName, int price, Stock stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }
}
