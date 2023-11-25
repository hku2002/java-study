package com.example.stocksynchronicityexam.service;

import com.example.stocksynchronicityexam.domain.entity.Stock;
import com.example.stocksynchronicityexam.domain.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    //@Transactional
    public synchronized void decrease(Long id, int quantity) {
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        stockRepository.save(stock);
    }

}
