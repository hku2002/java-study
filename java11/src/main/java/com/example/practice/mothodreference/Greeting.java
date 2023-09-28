package com.example.practice.mothodreference;

public class Greeting {

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String sayHi(String name) {
        return "hi " + name;
    }

}
