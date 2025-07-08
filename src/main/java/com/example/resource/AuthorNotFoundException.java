
package com.example.resource;

// REST endpoints for authornotfoundexception operations.
public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String message) {
        super(message);
    }
}
