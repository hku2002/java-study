package com.example.order.service.order;

import com.example.order.domain.order.Order;
import com.example.order.domain.order.OrderProduct;
import com.example.order.domain.order.OrderProductRepository;
import com.example.order.domain.order.OrderRepository;
import com.example.order.domain.product.Product;
import com.example.order.domain.product.ProductRepository;
import com.example.order.domain.stock.Stock;
import com.example.order.domain.stock.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.order.domain.order.enumtype.OrderStatus.READY;
import static com.example.order.domain.product.enumtype.ProductStatus.ON_SALE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StockRepository stockRepository;

    @BeforeEach
    void beforeEach() {
        orderRepository.deleteAll();
        orderProductRepository.deleteAll();
        productRepository.deleteAll();
        stockRepository.deleteAll();
    }

    @Test
    @DisplayName("주문 완료 성공 테스트")
    void orderCompleteSuccessTest() {
        // given
        Stock stock1 = Stock.builder()
                .stockName("재고1")
                .quantity(10)
                .build();
        Stock stock2 = Stock.builder()
                .stockName("재고2")
                .quantity(5)
                .build();
        stockRepository.saveAllAndFlush(List.of(stock1, stock2));
        Product product1 = Product.builder()
                .productName("상품1")
                .price(4000)
                .status(ON_SALE)
                .build();
        Product product2 = Product.builder()
                .productName("상품2")
                .price(6000)
                .status(ON_SALE)
                .build();
        product1.addStock(stock1);
        product2.addStock(stock2);
        productRepository.saveAllAndFlush(List.of(product1, product2));
        OrderProduct orderProduct1 = OrderProduct.builder()
                .productId(product1.getId())
                .productName("상품1")
                .price(4000)
                .build();
        OrderProduct orderProduct2 = OrderProduct.builder()
                .productId(product2.getId())
                .productName("상품2")
                .price(6000)
                .build();
        Order order = Order.builder()
                .orderName("주문1")
                .totalPrice(10_000)
                .orderProducts(List.of(orderProduct1, orderProduct2))
                .status(READY)
                .build();
        orderProduct1.addOrder(order);
        orderProduct2.addOrder(order);
        orderRepository.saveAndFlush(order);
        //orderProductRepository.saveAllAndFlush(List.of(orderProduct1, orderProduct2));

        // when
        Long orderId = orderService.completeOrder(order.getId());

        // then
        assertThat(orderId).isEqualTo(order.getId());
    }

}