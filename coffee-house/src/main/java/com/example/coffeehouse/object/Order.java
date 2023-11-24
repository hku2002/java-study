package com.example.coffeehouse.object;

import com.example.coffeehouse.object.coffee.Coffee;
import com.example.coffeehouse.object.coffee.Size;
import lombok.Getter;

@Getter
public class Order {

    public Long id;
    public String coffeeName;
    public int price;
    public Size size;

    public Order (String coffeeName, int price, Size size) {
        this.id = 1L;
        this.coffeeName = coffeeName;
        this.price = price;
        this.size = size;
    }

}
