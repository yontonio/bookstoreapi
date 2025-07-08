package com.example.resource;


// Exposes REST endpoints for ordernotfoundexception operations.
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
