package pattern.facade.service;

import pattern.facade.model.Order;
import pattern.facade.model.Stock;

import java.time.LocalDateTime;

public class OrderService {

    public Order createOrder() {
        Stock stock = new Stock();
        stock.setId(1L);
        stock.setQuantity(10);
        stock.setCreatedAt(LocalDateTime.now());

        Order order = new Order();
        order.setId(1L);
        order.setName("첫번째 주문");
        order.setStatus("CREATED");
        order.setTotalPrice(10_000);
        order.setStock(stock);
        order.setCreatedAt(LocalDateTime.now());
        return order;
    }

    public void completeOrder(Order order) {
        order.setStatus("ORDERED");
        System.out.println("주문이 완료되었습니다.");
    }

}
