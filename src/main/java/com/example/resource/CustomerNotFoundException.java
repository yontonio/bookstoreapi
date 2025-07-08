
package com.example.resource;

// REST endpoints for customernotfoundexeption operations.
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
