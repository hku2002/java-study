package com.example.api.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class RouteHandler implements HttpHandler {

    private final GetHandler getHandler = new GetHandler();

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String responseBody = null;
        if ("GET".equals(exchange.getRequestMethod())) {
            responseBody = getHandler.responseBodyByPath(exchange.getRequestURI().getPath());
        }

        assert responseBody != null;
        byte[] responseBodyByte = responseBody.getBytes();
        exchange.sendResponseHeaders(200, responseBody.length());
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBodyByte);
        outputStream.close();
    }
}
