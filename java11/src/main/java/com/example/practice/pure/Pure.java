package com.example.practice.pure;

public class Pure {

    public static void main(String[] args) {
        // 순수하지 않은 함수(외부 변수 참조)
        int addNumber = 10;
        CalculateNumber calculateNumber = number -> number + addNumber;
        System.out.println(calculateNumber.add(10));

        // 순수 함수(외부 변수 참조 없음)
        CalculateNumber calculateNumberPure = inputNumber -> inputNumber + 10;
        System.out.println(calculateNumberPure.add(10));
    }
}
