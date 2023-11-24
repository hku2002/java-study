package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;
import lombok.Getter;

@Getter
public class Order {

    public String orderName;
    public Coffee coffee;

    public Order (String orderName, Coffee coffee) {
        this.orderName = orderName;
        this.coffee = coffee;
    }

}
