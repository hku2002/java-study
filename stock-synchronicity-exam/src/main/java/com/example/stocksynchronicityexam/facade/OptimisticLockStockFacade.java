package com.example.stocksynchronicityexam.facade;

import com.example.stocksynchronicityexam.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OptimisticLockStockFacade {

    private final StockService stockService;

    public void decrease(Long id, int quantity) throws InterruptedException {
        while (true) {
            try {
                stockService.optimisticDecrease(id, quantity);
                break;
            } catch (Exception e) {
                Thread.sleep(50);
            }

        }
    }

}
