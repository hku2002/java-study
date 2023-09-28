package com.study.effective.chapter01.item01;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private boolean isEmergency;
    private boolean isOrderAvailability;
    private List<Product> products = new ArrayList<>();

    public static Order createEmergencyOrder(Long id, List<Product> products) {
        Order order = new Order();
        order.id = id;
        order.isEmergency = true;
        order.isOrderAvailability = true;
        order.products = products;
        return order;
    }

    public static Order createUnableOrder(Long id, List<Product> products) {
        Order order = new Order();
        order.id = id;
        order.isEmergency = false;
        order.isOrderAvailability = false;
        order.products = products;
        return order;
    }
}
