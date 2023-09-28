package com.example.practice.mothodreference;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Foo {

    public static void main(String[] args) {
        UnaryOperator<String> sayHi = Greeting::sayHi;
        System.out.println(sayHi.apply("connie1"));

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("connie2"));

        Function<String, Greeting> greetingName = Greeting::new;
        System.out.println(greetingName.apply("connie3"));
    }

}
