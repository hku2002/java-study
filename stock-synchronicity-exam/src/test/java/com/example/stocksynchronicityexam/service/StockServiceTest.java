package com.example.stocksynchronicityexam.service;

import com.example.stocksynchronicityexam.domain.entity.Stock;
import com.example.stocksynchronicityexam.domain.repository.StockRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StockServiceTest {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockService stockService;

    @Test
    @DisplayName("재고가 올바르게 감소한다.")
    void decreaseSuccessTest() {
        // given
        stockRepository.save(new Stock(100L, 10));

        // when
        stockService.decrease(1L, 3);

        // then
        Stock stock = stockRepository.findById(1L).orElseThrow();
        assertThat(stock.getQuantity()).isEqualTo(7);
    }

}