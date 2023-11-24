package com.example.coffeehouse.object.coffee;

import com.example.coffeehouse.object.Order;
import lombok.Getter;

@Getter
public class Coffee {

    private final String coffeeName;
    private final Size size;
    private final int degree;

    public Coffee(String coffeeName, Size size, int degree) {
        this.coffeeName = coffeeName;
        this.size = size;
        this.degree = degree;
    }

    public static Coffee create(Order order) {
        int degree = 100;
        if (order.isIce()) {
            degree = 15;
        }
        return new Coffee(order.getCoffeeName(), order.getSize(), degree);
    }

}
