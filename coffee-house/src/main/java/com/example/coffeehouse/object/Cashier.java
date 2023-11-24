package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

public class Cashier {

    public String cashierName;

    public Cashier (String cashierName) {
        this.cashierName = cashierName;
    }

    public Coffee createOrderFromCustomer(Order order) {
        Barista barista = new Barista("Adam");
        return requestMakeCoffeeToBarista(order, barista);
    }

    private Coffee requestMakeCoffeeToBarista(Order order, Barista barista) {
        System.out.println(cashierName + "님이 " + barista.baristaName + "에게 커피 제조를 요청하였습니다.");
        return barista.createCoffee(order);
    }

}
