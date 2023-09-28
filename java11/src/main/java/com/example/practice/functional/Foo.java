package com.example.practice.functional;

public class Foo {

    public static void main(String[] args) {

        // java 8 이전 표현 방식
        DoSomething doSomethingBeforeJava8 = new DoSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello world before 8");
            }
        };

        // 자바 8 이후 표현 방식
        DoSomething doSomethingAfterJava8 = () -> System.out.println("Hello world after 8");

        doSomethingBeforeJava8.doIt();
        doSomethingAfterJava8.doIt();
        doSomethingAfterJava8.printGender();
        DoSomething.printMyName();
    }
}
