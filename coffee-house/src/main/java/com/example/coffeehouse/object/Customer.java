package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

public class Customer {

    public String name;

    public Coffee requestOrderToCashier(Order order, Cashier cashier) {
        return cashier.createOrderFromCustomer(order);
    }

}
