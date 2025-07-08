
package com.example.model;

// Represents the customer entity.
public class Customer {
    private int id;
    private String name;
    private String email;

    public Customer() {}

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Returns customers id.
    public int getId() { return id; }
    // Sets customers id.
    public void setId(int id) { this.id = id; }

    // Returns customers name.
    public String getName() { return name; }
    // Sets customers name.
    public void setName(String name) { this.name = name; }

    // Returns customers email.
    public String getEmail() { return email; }
    // Sets customers email.
    public void setEmail(String email) { this.email = email; }
}
