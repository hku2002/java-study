package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

import java.util.ArrayList;
import java.util.List;

public class Barista {

    public String baristaName;

    public Barista (String baristaName) {
        this.baristaName = baristaName;
    }

    public Coffee createCoffeeFromCashier(Order order) {
        System.out.println(baristaName + " 님이 " + order.getCoffeeName() + " 제조 요청을 받았습니다.");
        return createCoffee(order);
    }

    public List<Coffee> createCoffeesFromCashier(List<Order> orders) {
        System.out.println(baristaName + " 님이 커피" + orders.size() + " 만큼 제조 요청을 받았습니다.");
        return orders.stream().map(this::createCoffee).toList();
    }

    private Coffee createCoffee(Order order) {
        System.out.println(baristaName + "님이 " + order.getCoffeeName() + "를 만들기 시작합니다.");
        Coffee coffee = Coffee.create(order);
        System.out.println(baristaName + "님이 " + coffee.getCoffeeName() + "를 만들었습니다.");
        return coffee;
    }

}
