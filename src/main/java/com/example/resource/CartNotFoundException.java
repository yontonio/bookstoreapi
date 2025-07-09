
package com.example.resource;
// REST endpoints for cartnotfoundexeptions operations.
public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(String message) {
        super(message);
    }
}
