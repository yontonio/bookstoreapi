
package com.example.model;

import java.util.List;

// Represents the order entity.
public class Order {
    private int id;
    private int customerId;
    private List<CartItem> items;

    public Order() {}

    public Order(int id, int customerId, List<CartItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
    }

    // Returns order id.
    public int getId() { return id; }
    // Sets order id.
    public void setId(int id) { this.id = id; }

    // Returns customers id.
    public int getCustomerId() { return customerId; }
    // Sets customers id.
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    // Returns all items in cart.
    public List<CartItem> getItems() { return items; }
    // Sets items in cart.
    public void setItems(List<CartItem> items) { this.items = items; }
}
