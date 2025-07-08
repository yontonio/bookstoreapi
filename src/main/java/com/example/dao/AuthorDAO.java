package com.example.dao;

import com.example.model.Author;
import java.util.*;

// Provides CRUD access to author data.
public class AuthorDAO {

    // In-memory storage of authors
    private static final Map<Integer, Author> authors = new HashMap<>();

    /** next ID to assign when a new author is added */
    private static int idCounter = 1;

// Preloaded Authors
    static {
        authors.put(idCounter,
            new Author(idCounter++, "Miguel de Cervantes",
                       "Autor de La colmena"));
        authors.put(idCounter,
            new Author(idCounter++, "Gabriel García Márquez",
                       "Galician writer from 1920"));
        authors.put(idCounter,
            new Author(idCounter++, "Federico García Lorca",
                       "novelist from Murcia, made la Cianaga"));
    }

    // Returns all authors.
    public List<Author> getAll() {
        return new ArrayList<>(authors.values());
    }

    // Gets authors.
    public Author get(int id) {
        return authors.get(id);
    }

    // Adds a new author .
    public Author add(Author author) {
        author.setId(idCounter++);
        authors.put(author.getId(), author);
        return author;
    }

    // Updates an existing author.
    public Author update(int id, Author author) {
        if (!authors.containsKey(id)) return null;
        author.setId(id);
        authors.put(id, author);
        return author;
    }

    // Deletes a specific author.
    public Author delete(int id) {
        return authors.remove(id);
    }
}
