package com.aop.sample.order;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    @DisplayName("aop test")
    void aopInfo() {
        log.info("isAopProxy, orderService: {}", AopUtils.isAopProxy(orderService));
        log.info("isAopProxy, orderRepository: {}", AopUtils.isAopProxy(orderRepository));
    }

    @Test
    @DisplayName("success")
    void success() {
        orderService.orderItem("itemA");
    }

    @Test
    @DisplayName("exception")
    void exception() {
        Assertions.assertThatThrownBy(() -> orderService.orderItem("ex"))
                .isInstanceOf(IllegalStateException.class);
    }

}
