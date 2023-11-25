package com.example.stocksynchronicityexam.facade;

import com.example.stocksynchronicityexam.domain.repository.NamedLockRepository;
import com.example.stocksynchronicityexam.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class NamedLockStockFacade {

    private final NamedLockRepository namedLockRepository;
    private final StockService stockService;

    @Transactional
    public void decrease(Long id, int quantity) {
        namedLockRepository.getLock(id.toString());
        stockService.namedLockDecrease(id, quantity);
        namedLockRepository.releaseLock(id.toString());
    }
}
