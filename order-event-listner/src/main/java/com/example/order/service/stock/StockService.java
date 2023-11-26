package com.example.order.service.stock;

import com.example.order.domain.stock.Stock;
import com.example.order.domain.stock.StockRepository;
import com.example.order.service.stock.dto.StockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public StockResponse getStock(Long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("재고가 존재하지 않습니다."));
        return StockResponse.from(stock);
    }
}
