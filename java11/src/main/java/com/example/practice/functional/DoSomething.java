package com.example.practice.functional;

@FunctionalInterface
public interface DoSomething {

    void doIt();

    static void printMyName() {
        System.out.println("Connie");
    }

    default void printGender() {
        System.out.println("Man");
    }

}
