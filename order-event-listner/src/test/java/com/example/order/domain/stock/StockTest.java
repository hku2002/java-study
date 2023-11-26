package com.example.order.domain.stock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StockTest {

    @Test
    @DisplayName("재고 차감이 올바르게 작동한다.")
    void deductSuccessTest() {
        // given
        Stock stock = Stock.builder()
                .stockName("재고1")
                .quantity(10)
                .build();

        // when
        stock.deductQuantity(1);

        // then
        assertThat(stock.getQuantity()).isEqualTo(9);
    }

    @Test
    @DisplayName("재고 차감시 재고가 0개 이하면 예외를 던진다.")
    void deductZeroExceptionTest() {
        // given
        Stock stock = Stock.builder()
                .stockName("재고1")
                .quantity(2)
                .build();

        // when, then
        assertThatThrownBy(() -> stock.deductQuantity(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("재고가 존재하지 않습니다.");
    }

}