package com.example.order.service.product.dto;

import com.example.order.domain.product.Product;
import com.example.order.domain.product.enumtype.ProductStatus;
import lombok.Builder;

public record ProductResponse(Long id, String productName, int price, ProductStatus status) {

    @Builder
    public ProductResponse {
    }

    public static ProductResponse from(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }
}
