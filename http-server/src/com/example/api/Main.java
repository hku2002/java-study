package com.example.api;

import com.example.api.config.HttpServerManager;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("simple http server");

        HttpServerManager serverManager = new HttpServerManager();
        serverManager.start();

        serverManager.stop();

    }

}
