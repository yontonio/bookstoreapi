
package com.example.model;

// Represents the cart item entity.
public class CartItem {
    private int bookId;
    private int quantity;

    public CartItem() {}

    public CartItem(int bookId, int quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    // Returns books id.
    public int getBookId() { return bookId; }
    // Sets books id.
    public void setBookId(int bookId) { this.bookId = bookId; }

    // Returns quantity.
    public int getQuantity() { return quantity; }
    // Sets quantity.
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
