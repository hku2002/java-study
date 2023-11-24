package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

public class Customer {

    public String name;

    public static Coffee requestOrderToCashier(Order order) {
        return Cashier.createOrderFromCustomer(order);
    }

}
