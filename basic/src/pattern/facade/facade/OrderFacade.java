package pattern.facade.facade;

import pattern.facade.model.Order;
import pattern.facade.service.OrderService;
import pattern.facade.service.PayService;
import pattern.facade.service.StockService;

public class OrderFacade {

    public void order() {

        OrderService orderService = new OrderService();
        Order order = orderService.createOrder();

        PayService payService = new PayService();
        payService.pay(order);

        StockService stockService = new StockService();
        stockService.stockDeduct(order.getStock(), 1);

        orderService.completeOrder(order);

    }
}
