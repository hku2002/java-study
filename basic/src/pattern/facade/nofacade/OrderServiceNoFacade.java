package pattern.facade.nofacade;

import pattern.facade.model.Order;
import pattern.facade.model.Stock;
import pattern.facade.service.PayService;
import pattern.facade.service.StockService;

import java.time.LocalDateTime;

public class OrderServiceNoFacade {

    public void order() {

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

        PayService payService = new PayService();
        payService.pay(order);

        StockService stockService = new StockService();
        stockService.stockDeduct(order.getStock(), 1);

        order.setStatus("ORDERED");
        System.out.println("주문 완료");

    }
}
