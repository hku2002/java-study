package pattern.facade.service;

import pattern.facade.model.Order;

public class PayService {

    public boolean pay(Order order) {
        if (order.getId() == null) {
            System.out.println("주문 정보가 없습니다.");
            return false;
        }

        System.out.println("결제가 성공하였습니다.");
        return true;
    }

}
