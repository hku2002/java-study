package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

public class Cashier {

    public String CashierName;

    private Coffee makeCoffee(Order order) {
        return new Coffee();
    }

}
