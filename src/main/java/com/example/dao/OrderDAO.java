
package com.example.dao;

import com.example.model.Order;
import com.example.model.CartItem;
import java.util.*;

// Provides CRUD access to order data.
public class OrderDAO {
    private static final Map<Integer, List<Order>> orders = new HashMap<>();
    private static int orderCounter = 1;

    // Returns all orders.
    public List<Order> getAll(int customerId) {
        return orders.getOrDefault(customerId, new ArrayList<>());
    }

    // Returns a specific order.
    public Order get(int customerId, int orderId) {
        List<Order> customerOrders = orders.get(customerId);
        if (customerOrders == null) return null;
        for (Order o : customerOrders) {
            if (o.getId() == orderId) return o;
        }
        return null;
    }

    // Adds a new order.
    public Order add(int customerId, List<CartItem> items) {
        Order order = new Order(orderCounter++, customerId, new ArrayList<>(items));
        orders.computeIfAbsent(customerId, k -> new ArrayList<>()).add(order);
        return order;
    }
}
