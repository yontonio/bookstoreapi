package com.example.resource;

// REST endpoints for invalidinputexeption operations.
public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
