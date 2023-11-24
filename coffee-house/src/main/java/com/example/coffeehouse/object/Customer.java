package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

public class Customer {

    public String name;

    public Customer(String name) {
        this.name = name;
    }

    public Coffee requestOrderToCashier(Order order, Cashier cashier) {
        System.out.println(name + "님이 " + cashier.cashierName + "에게 주문을 요청하였습니다.");
        return cashier.createOrderFromCustomer(order);
    }

}
