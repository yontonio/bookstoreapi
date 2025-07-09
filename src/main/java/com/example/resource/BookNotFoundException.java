
package com.example.resource;

// REST endpoints for booknotfoundexception operations.
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
