package com.example.api.config;

import com.example.api.handler.RouteHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerManager {

    private static final String DEFAULT_HOST = "127.0.0.1";
    private static final int DEFAULT_PORT = 8080;
    private static final int DEFAULT_BACKLOG = 0;
    private static final int DEFAULT_STOP_DELAY = 3;
    private final HttpServer httpServer;

    public HttpServerManager() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(DEFAULT_HOST, DEFAULT_PORT), DEFAULT_BACKLOG);
        httpServer.createContext("/", new RouteHandler());
    }

    public void start() {
        httpServer.start();
        System.out.println("서버가 실행되었습니다.");
    }

    public void stop() {
        stop(DEFAULT_STOP_DELAY);
    }

    public void stop(int delay) {
        System.out.println(delay + "초 후 서버가 종료됩니다.");
        httpServer.stop(delay);
        System.out.println("서버가 종료되었습니다.");
    }


}
