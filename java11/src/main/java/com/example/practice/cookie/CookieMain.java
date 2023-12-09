package com.example.practice.cookie;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class CookieMain {

    public static void main(String[] args) {

        CookieWebSessionIdResolver cookieWebSessionIdResolver = new CookieWebSessionIdResolver();
        cookieWebSessionIdResolver.addCookieInitializer((builder) -> builder.path("/")
                .domain("www.first-domain.com")
                .secure(true)
                .httpOnly(true)
                .maxAge(Duration.ofMinutes(5)));

        log.info("test1");


        cookieWebSessionIdResolver.expireSession();

        log.info("test2");

    }
}
