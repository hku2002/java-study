package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

import java.util.List;

public class Cashier {

    public String cashierName;

    public Cashier (String cashierName) {
        this.cashierName = cashierName;
    }

    public Coffee createOrderFromCustomer(Order order) {
        System.out.println(cashierName + "님이 " + order.getCoffeeName() + " 주문을 받았습니다.");
        Barista barista = new Barista("Adam");
        return requestMakeCoffeeToBarista(order, barista);
    }

    public List<Coffee> createOrdersFromCustomer(List<Order> orders) {
        System.out.println(cashierName + "님이 " + orders.size() + " 만큼 주문을 받았습니다.");
        Barista barista = new Barista("Eve");
        return orders.stream().map(order -> requestMakeCoffeeToBarista(order, barista)).toList();
    }

    private Coffee requestMakeCoffeeToBarista(Order order, Barista barista) {
        System.out.println(cashierName + " 님이 " + barista.baristaName + "에게 " + order.getCoffeeName() + " 제조를 요청하였습니다.");
        Coffee coffee = barista.createCoffeeFromCashier(order);
        System.out.println(cashierName + " 님이 " + barista.baristaName + "에게 " + coffee.getCoffeeName() + "를 받았습니다.");
        return coffee;
    }

}
