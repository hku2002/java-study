package com.example.coffeehouse.flow;

import com.example.coffeehouse.object.Cashier;
import com.example.coffeehouse.object.Company;
import com.example.coffeehouse.object.Customer;
import com.example.coffeehouse.object.Order;
import com.example.coffeehouse.object.coffee.Coffee;
import com.example.coffeehouse.object.coffee.Size;

import java.util.List;

public class MainFlow {

    public static void main(String[] args) {
        Customer customer = new Customer("Connie");
        Order order = new Order("Americano", 5000, Size.MEDIUM, true);
        Cashier cashier = new Cashier("Steve");

        Coffee responseCoffee = customer.requestOrderToCashier(order, cashier);

        System.out.println("===== 최종 생성된 커피 정보 =====");
        System.out.println("coffee name: " + responseCoffee.getCoffeeName());
        System.out.println("coffee degree: " + responseCoffee.getDegree());
        System.out.println("coffee size: " + responseCoffee.getSize());
        System.out.println("=============================");

        Company company = new Company("Object Company");
        Order order1 = new Order("Americano", 5000, Size.MEDIUM, true);
        Order order2 = new Order("Americano", 5500, Size.BIG, true);
        Order order3 = new Order("Cafe Mocha", 6000, Size.MEDIUM, true);
        company.requestOrdersToCashier(List.of(order1, order2, order3), cashier);


    }

}
