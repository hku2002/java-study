package com.example.practice.functional;

import java.util.function.Function;
import java.util.function.IntFunction;

public class Plus {

    public static void main(String[] args) {
        // 아래 3개는 같음

        // 방법1
        PlusTen plusTen1 = new PlusTen();
        int result1 = plusTen1.apply(5);

        // 방법2
        Function<Integer, Integer> plusTen2 = number -> number + 10;
        int result2 = plusTen2.apply(5);

        // 방법 2-1
        IntFunction<Integer> plusTen3 = num -> num + 5;
        int result3 = plusTen3.apply(5);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        // 조합하기
        Function<Integer, Integer> multiplyTwo = number -> number * 2;
        Function<Integer, Integer> multiplyTwoAndPlusTen = plusTen2.compose(multiplyTwo);
        System.out.println(multiplyTwoAndPlusTen.apply(2));


    }
}
