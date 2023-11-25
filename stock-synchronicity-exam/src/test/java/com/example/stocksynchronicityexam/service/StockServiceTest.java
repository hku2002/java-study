package com.example.stocksynchronicityexam.service;

import com.example.stocksynchronicityexam.domain.entity.Stock;
import com.example.stocksynchronicityexam.domain.repository.StockRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StockServiceTest {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockService stockService;

    @BeforeEach
    void beforeEach() {
        stockRepository.saveAndFlush(new Stock(1L, 100));
    }

    @AfterEach
    void afterEach() {
        stockRepository.deleteAll();
    }

    @Test
    @DisplayName("재고가 올바르게 감소한다.")
    void decreaseSuccessTest() {

        // when
        stockService.decrease(1L, 3);

        // then
        Stock stock = stockRepository.findById(1L).orElseThrow();
        assertThat(stock.getQuantity()).isEqualTo(97);
    }
    
    @Test
    @DisplayName("동시에 100개 감소 요청 시 재고가 0 이하가 되어서는 안된다.")
    void concurrentDecrease100RequestTest() throws InterruptedException {
        // given
        int threadCount = 100;

        // when
        ExecutorService executor = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                stockService.decrease(1L, 1);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();

        // then
        Stock stock = stockRepository.findById(1L).orElseThrow();
        assertThat(stock.getQuantity()).isEqualTo(0);
    }

}