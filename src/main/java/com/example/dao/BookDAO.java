package com.example.dao;

import com.example.model.Book;
import com.example.resource.InvalidInputException;
import java.util.*;

// Provides CRUD access to book data.
public class BookDAO {
    private static final Map<Integer, Book> books = new HashMap<>();
    private static int idCounter = 1;

    // Returns all books.
    public List<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    // Returns a specific book.
    public Book get(int id) {
        return books.get(id);
    }

    // Adds a new book.
    public Book add(Book book) {
        validate(book);
        book.setId(idCounter++);
        books.put(book.getId(), book);
        return book;
    }

    //Updates an existing book.
   public Book update(int id, Book book) {
    Book existingBook = books.get(id);
    if (existingBook == null) return null;

    validate(book);

    existingBook.setTitle(book.getTitle());
    existingBook.setPrice(book.getPrice());
    existingBook.setAuthorId(book.getAuthorId());
    existingBook.setStock(book.getStock()); 
    existingBook.setPublicationYear(book.getPublicationYear()); 

    return existingBook;
}


    // Deletes a book.
    public Book delete(int id) {
        return books.remove(id);
    }
    // Validates books.
    private void validate(Book book) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty())
            throw new InvalidInputException("Book title cannot be empty.");

        if (book.getIsbn() == null || book.getIsbn().trim().isEmpty())
            throw new InvalidInputException("Book ISBN cannot be empty.");

        if (book.getPrice() < 0)
            throw new InvalidInputException("Book price cannot be negative.");

        if (book.getAuthorId() <= 0)
            throw new InvalidInputException("Book must be linked to a valid author ID.");

        if (book.getStock() < 0)
            throw new InvalidInputException("Stock cannot be negative.");

        if (book.getPublicationYear() <= 0)
            throw new InvalidInputException("Publication year must be a positive number.");
    }
}
