package com.example.coffeehouse.object.coffee;

import com.example.coffeehouse.object.Order;
import lombok.Getter;

@Getter
public class Coffee {

    private final String coffeeName;
    private final int price;
    private final Size size;

    public Coffee(Order order) {
        this.coffeeName = order.getCoffeeName();
        this.price = order.getPrice();
        this.size = order.getSize();
    }

    public static Coffee create(Order order) {
        return new Coffee(order);
    }

}
