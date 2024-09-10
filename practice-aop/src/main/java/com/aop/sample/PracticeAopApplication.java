package com.aop.sample;

import com.aop.sample.order.aop.AspectV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AspectV1.class)
@SpringBootApplication
public class PracticeAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeAopApplication.class, args);
    }

}
