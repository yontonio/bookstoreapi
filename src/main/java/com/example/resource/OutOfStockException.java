package com.example.resource;

// REST endpoints for outofstockexception operations.
public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }
}
