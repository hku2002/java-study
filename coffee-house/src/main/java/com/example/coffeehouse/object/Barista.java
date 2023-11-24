package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

public class Barista {

    public String baristaName;

    public Barista (String baristaName) {
        this.baristaName = baristaName;
    }

    public Coffee createCoffee(Order order) {
        System.out.println(baristaName + "님이 커피를 만들기 시작합니다.");
        Coffee coffee = Coffee.create(order);
        System.out.println(baristaName + "님이 커피를 만들었습니다.");
        return coffee;
    }

}
