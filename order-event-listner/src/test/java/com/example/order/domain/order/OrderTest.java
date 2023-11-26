package com.example.order.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.order.domain.order.enumtype.OrderStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {

    @Test
    @DisplayName("주문 완료 처리가 올바르게 작동한다.")
    void completeStatusSuccessTest() {
        // given
        Order order = Order.builder()
                .orderName("샘플 주문1")
                .totalPrice(1000)
                .status(READY)
                .build();

        // when
        order.completeStatus();

        // then
        assertThat(order.getStatus()).isEqualTo(COMPLETE);
    }

    @Test
    @DisplayName("주문 완료 처리 시 주문 상태가 준비 상태가 아닌 경우 예외가 발생한다.")
    void orderCompleteValidationExceptionTest() {
        // given
        Order order = Order.builder()
                .orderName("샘플 주문1")
                .totalPrice(1000)
                .status(CANCEL)
                .build();

        // when, then
        assertThatThrownBy(order::completeStatus)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("주문 완료 불가능한 상태입니다.");
    }

}