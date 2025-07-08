
package com.example.dao;

import com.example.model.CartItem;
import java.util.*;

// Provides CRUD access to cart data.
public class CartDAO {
    private static final Map<Integer, List<CartItem>> carts = new HashMap<>();

    //Returns specific cart.
    public List<CartItem> getCart(int customerId) {
        return carts.getOrDefault(customerId, new ArrayList<>());
    }

    // Adds a new item to the cart.
    public void addItem(int customerId, CartItem item) {
        carts.computeIfAbsent(customerId, k -> new ArrayList<>()).add(item);
    }

    // Updates an existing item in the cart.
    public boolean updateItem(int customerId, CartItem item) {
        List<CartItem> cart = carts.get(customerId);
        if (cart == null) return false;
        for (CartItem c : cart) {
            if (c.getBookId() == item.getBookId()) {
                c.setQuantity(item.getQuantity());
                return true;
            }
        }
        return false;
    }

    // Deletes item from cart.
    public boolean removeItem(int customerId, int bookId) {
        List<CartItem> cart = carts.get(customerId);
        if (cart == null) return false;
        return cart.removeIf(item -> item.getBookId() == bookId);
    }

    // Clears cart.
    public void clearCart(int customerId) {
        carts.remove(customerId);
    }
}
