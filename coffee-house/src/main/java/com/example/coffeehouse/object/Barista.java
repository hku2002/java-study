package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

public class Barista {

    public String baristaName;

    public Barista (String baristaName) {
        this.baristaName = baristaName;
    }

    public Coffee createCoffee(Order order) {
        return Coffee.create(order);
    }

}
