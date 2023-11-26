package com.example.order.service.stock.dto;

import com.example.order.domain.stock.Stock;
import lombok.Builder;

public record StockResponse(Long id, String stockName, int quantity) {

    @Builder
    public StockResponse {
    }

    public static StockResponse from(Stock stock) {
        return StockResponse.builder()
                .id(stock.getId())
                .stockName(stock.getStockName())
                .quantity(stock.getQuantity())
                .build();
    }

}
