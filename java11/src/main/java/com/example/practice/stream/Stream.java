package com.example.practice.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {


    public static void main(String[] args) {
        List<String> beforeNames = List.of("connie", "gildong", "foo", "Adam");
        List<String> afterNames = List.of("connie", "gildong", "foo", "Adam");

        // 아래 2개는 같다.
        // 자바 8 이전 방식
        List<String> beforeUpperNames = new ArrayList<>();
        for (String beforeName : beforeNames) {
            beforeUpperNames.add(beforeName.toUpperCase());
        }
        for (String beforeUpperName : beforeUpperNames) {
            System.out.println(beforeUpperName);
        }

        System.out.println("===================");

        // 자바 8 부터 가능한 stream
        List<String> afterUpperNames = afterNames.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        afterUpperNames.forEach(System.out::println);
    }
}
