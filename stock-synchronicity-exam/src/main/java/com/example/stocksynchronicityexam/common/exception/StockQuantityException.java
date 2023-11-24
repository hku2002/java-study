package com.example.stocksynchronicityexam.common.exception;

public class StockQuantityException extends RuntimeException {

    private final int status;
    private final String message;

    public StockQuantityException(int status, String message) {
        this.status = status;
        this.message = message;
    }
    public StockQuantityException(String message) {
        this.status = 400;
        this.message = message;
    }

}
