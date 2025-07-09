package com.example.model;

// Represents the book entity.
public class Book {
    private int id;
    private String title;
    private int authorId;
    private String isbn;
    private double price;
    private int stock; 
    private int publicationYear; 

    public Book() {}

    public Book(int id, String title, int authorId, String isbn, double price, int stock, int publicationYear) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.isbn = isbn;
        this.price = price;
        this.stock = stock;
        this.publicationYear = publicationYear;
    }

    // Returns books id.
    public int getId() { return id; }
    // Sets books id.
    public void setId(int id) { this.id = id; }

    // Returns books title.
    public String getTitle() { return title; }
    // Sets books title.
    public void setTitle(String title) { this.title = title; }

    // Returns authors id.
    public int getAuthorId() { return authorId; }
    // Sets authors id.
    public void setAuthorId(int authorId) { this.authorId = authorId; }

    // Returns books isbn.
    public String getIsbn() { return isbn; }
    // Sets isbn.
    public void setIsbn(String isbn) { this.isbn = isbn; }

    // Returns books price.
    public double getPrice() { return price; }
    // Sets price.
    public void setPrice(double price) { this.price = price; }

    // Returns books stock.
    public int getStock() { return stock; } 
    // Sets stock.
    public void setStock(int stock) { this.stock = stock; } 

    // Returns books publication year.
    public int getPublicationYear() { return publicationYear; } 
    // Sets books publication year.
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; } 
}
