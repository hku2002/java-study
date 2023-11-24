package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;

public class Cashier {

    public String CashierName;

    public Cashier (String cashierName) {
        this.CashierName = cashierName;
    }

    public Coffee createOrderFromCustomer(Order order) {
        Barista barista = new Barista("Adam");
        return requestMakeCoffeeToBarista(order, barista);
    }

    private Coffee requestMakeCoffeeToBarista(Order order, Barista barista) {
        System.out.println(CashierName + "이 " + barista.baristaName + "에게 커피 제조를 요청하였습니다.");
        return barista.createCoffee(order);
    }

}
