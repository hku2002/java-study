package com.example.order.service.stock.dto;

import com.example.order.domain.stock.Stock;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StockResponse {

    private Long id;
    private String stockName;
    private int quantity;

    @Builder
    public StockResponse(Long id, String stockName, int quantity) {
        this.id = id;
        this.stockName = stockName;
        this.quantity = quantity;
    }

    public static StockResponse from(Stock stock) {
        return StockResponse.builder()
                .id(stock.getId())
                .stockName(stock.getStockName())
                .quantity(stock.getQuantity())
                .build();
    }

}
