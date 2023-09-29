package com.example.practice.stream;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Exam {

    public static void main(String[] args) {
        // Spring 강의 List 담기
        List<OnlineClass> springClasses = List.of(
                new OnlineClass(1L, "spring boot", true),
                new OnlineClass(2L, "spring data jpa", true),
                new OnlineClass(3L, "spring mvc", false),
                new OnlineClass(4L, "spring core", false),
                new OnlineClass(5L, "rest api development", false)
        );

        System.out.println("==============================");
        System.out.println("문제1. spring 으로 시작하는 수업 출력");
        springClasses.stream()
                .filter(name -> name.getTitle().startsWith("spring"))
                .forEach(name -> System.out.println(name.getTitle()));

        System.out.println("==============================");
        System.out.println("문제2. close 상태가 아닌 수업 출력");
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(openClass -> System.out.println(openClass.getTitle()));

        System.out.println("===================================");
        System.out.println("문제3. 수업 이름만 모아서 stream 만들기");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);


        // java 강의 List 담기
        List<OnlineClass> javaClasses = List.of(
                new OnlineClass(6L, "The Java, Test", true),
                new OnlineClass(7L, "The Java, Code manipulation", true),
                new OnlineClass(8L, "The Java, 8 to 11", false),
                new OnlineClass(9L, "spring and java, 8 to 11", true)
        );

        System.out.println("===================================");
        System.out.println("문제4. 두 수업 목록에 들어있는 모든 수업 아이디 출력");
        List<List<OnlineClass>> allClasses = List.of(springClasses, javaClasses);
        allClasses.stream()
                .flatMap(Collection::stream)
                .forEach(onlineClass -> System.out.print(onlineClass.getId() + " "));
        System.out.println();

        System.out.println("===================================");
        System.out.println("문제5. 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만 출력");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("===================================");
        System.out.println("문제6. 자바 수업 중에 Test 가 들어있는 수업이 있는지 확인 있으면 true 출력 없으면 false 출력");
        System.out.println(javaClasses.stream()
                        .anyMatch(java -> java.getTitle().contains("Test"))
        );

        System.out.println("===================================");
        System.out.println("문제7. 스프링과 자바 수업 중에 제목에 spring 이 들어간 것만 모아 제목 출력");
        allClasses.stream()
                .flatMap(Collection::stream)
                .filter(onlineClass -> onlineClass.getTitle().contains("spring"))
                .forEach(onlineClass -> System.out.println(onlineClass.getTitle()));

    }
}
