
package com.example.dao;

import com.example.model.Customer;
import java.util.*;


// Provides CRUD access to customer data.
public class CustomerDAO {
    private static final Map<Integer, Customer> customers = new HashMap<>();
    private static int idCounter = 1;

    // Returns all customers.
    public List<Customer> getAll() {
        return new ArrayList<>(customers.values());
    }

    // Gets a specific customer.
    public Customer get(int id) {
        return customers.get(id);
    }

    // Adds a new customer.
    public Customer add(Customer customer) {
        customer.setId(idCounter++);
        customers.put(customer.getId(), customer);
        return customer;
    }

    // Updates an existing customer.
    public Customer update(int id, Customer customer) {
        if (!customers.containsKey(id)) return null;
        customer.setId(id);
        customers.put(id, customer);
        return customer;
    }

    // Deletes a customer.
    public Customer delete(int id) {
        return customers.remove(id);
    }
}
