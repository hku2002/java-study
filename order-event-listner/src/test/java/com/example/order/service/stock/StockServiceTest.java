package com.example.order.service.stock;

import com.example.order.domain.stock.Stock;
import com.example.order.domain.stock.StockRepository;
import com.example.order.service.stock.dto.StockResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
class StockServiceTest {

    @Autowired
    StockService stockService;
    @Autowired
    StockRepository stockRepository;

    @BeforeEach
    void beforeEach() {
        stockRepository.deleteAll();
    }

    @Test
    @DisplayName("재고 1개 조회 시 dto 값에 올바르게 저장하여 응답주어야 한다.")
    void getStockSuccessTest() {
        // given
        Stock stock = Stock.builder()
                .stockName("재고1")
                .quantity(10)
                .build();
        stockRepository.saveAndFlush(stock);

        // when
        StockResponse stockResponse = stockService.getStock(stock.getId());

        // then
        assertAll(
                () -> assertThat(stockResponse).isNotNull(),
                () -> {
                    assert stockResponse != null;
                    assertThat(stockResponse.getId()).isEqualTo(stock.getId());
                }

        );
    }

    @Test
    @DisplayName("재고 정보가 없을 경우 예외가 발생해야 한다.")
    void emptyStockExceptionTest() {
        // given
        Stock stock = Stock.builder()
                .stockName("재고명1")
                .quantity(10)
                .build();
        stockRepository.saveAndFlush(stock);

        // when, then
        assertThatThrownBy(() -> stockService.getStock(10000L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("재고가 존재하지 않습니다.");
    }

}