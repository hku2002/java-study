package com.example.api.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class RouteHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        System.out.println("uri :" + uri);

        String responseBody = "{\"statusCode\": 200}";
        byte[] responseBodyByte = responseBody.getBytes();
        exchange.sendResponseHeaders(200, responseBody.length());
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBodyByte);
        outputStream.close();
    }
}
