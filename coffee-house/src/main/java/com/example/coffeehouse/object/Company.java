package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

import java.util.List;

public class Company {

    private final String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public List<Coffee> requestOrdersToCashier(List<Order> orders, Cashier cashier) {
        System.out.println(companyName + "에서 " + cashier.cashierName + "에게 " + orders.size() + " 만큼 주문을 요청합니다.");
        List<Coffee> coffees = cashier.createOrdersFromCustomer(orders);
        System.out.println(companyName + "에서 " + cashier.cashierName + "에게 " + coffees.size() + " 만큼 커피를 받았습니다.");
        return coffees;
    }
}
