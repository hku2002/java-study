package com.example.practice.functional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerMain {

    private String data;
    private Consumer<String> init = null;

    public void addInit(Consumer<String> initStr) {
        this.data = "first";
        this.init = initStr;
    }

    public void initTest(String data) {
        String a = "a";
        if (this.init != null) {
            init.accept(a);
        }
    }

    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("YeeSan");

        BiConsumer<String, String> consumer2 = (t, v) -> System.out.println(t + ", " + v);
        consumer2.accept("YeeSan", "JinYoung");

        IntConsumer consumer3 = System.out::println;
        consumer3.accept(2021);

        ConsumerMain main = new ConsumerMain();
        Consumer<String> str = System.out::println;
        str.accept("test");
        main.addInit(str);
        main.initTest("second");

    }

}
