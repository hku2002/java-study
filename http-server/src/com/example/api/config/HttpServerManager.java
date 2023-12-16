package com.example.api.config;

import com.example.api.handler.RouteHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerManager {

    private final HttpServer httpServer;

    public HttpServerManager() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress("127.0.0.1", 8080), 0);
        httpServer.createContext("/", new RouteHandler());
    }

    public void start() {
        httpServer.start();
        System.out.println("서버가 실행되었습니다.");
    }

    public void stop() {
        System.out.println("3초 후 서버가 종료됩니다.");
        httpServer.stop(3);
        System.out.println("서버가 종료되었습니다.");
    }


}
