package com.example.coffeehouse.flow;

import com.example.coffeehouse.object.Cashier;
import com.example.coffeehouse.object.Customer;
import com.example.coffeehouse.object.Order;
import com.example.coffeehouse.object.coffee.Coffee;
import com.example.coffeehouse.object.coffee.Size;

public class MainFlow {

    public static void main(String[] args) {
        Customer customer = new Customer("Connie");
        Order order = new Order("Americano", 5000, Size.MEDIUM, true);
        Cashier cashier = new Cashier("Steve");

        Coffee responseCoffee = customer.requestOrderToCashier(order, cashier);

        System.out.println("coffee name: " + responseCoffee.getCoffeeName());
        System.out.println("coffee degree: " + responseCoffee.getDegree());
        System.out.println("coffee size: " + responseCoffee.getSize());

    }

}
