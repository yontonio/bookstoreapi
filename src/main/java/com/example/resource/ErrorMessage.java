package com.example.resource;


// REST endpoints for error operations.
public class ErrorMessage {
    private String message;
    private int statusCode;

    public ErrorMessage() {}

    public ErrorMessage(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    // Returns message.
    public String getMessage() {
        return message;
    }

    // Returns status code.
    public int getStatusCode() {
        return statusCode;
    }
}