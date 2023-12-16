package com.example.api.handler;

import com.example.api.service.ProductService;

import java.io.IOException;

public class GetHandler {

    private final ProductService productService = new ProductService();

    public String responseBodyByPath(String path) throws IOException {

        String responseBody = "{\"statusCode\": 200}";
        if ("/products".equals(path)) {
            return productService.getProducts();
        }
        return responseBody;
    }

}
