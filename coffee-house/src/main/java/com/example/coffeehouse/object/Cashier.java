package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

public class Cashier {

    public String CashierName;

    public static Coffee createOrderFromCustomer(Order order) {
        return requestMakeCoffeeToBarista(order);
    }

    private static Coffee requestMakeCoffeeToBarista(Order order) {
        return Barista.createCoffee(order);
    }

}
