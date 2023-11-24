package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;
import com.example.coffeehouse.object.coffee.Size;
import lombok.Getter;

@Getter
public class Order {

    private final Long id;
    private final String coffeeName;
    private final int price;
    private final Size size;
    private final boolean isIce;

    public Order (String coffeeName, int price, Size size, boolean isIce) {
        this.id = 1L;
        this.coffeeName = coffeeName;
        this.price = price;
        this.size = size;
        this.isIce = isIce;
    }

}
