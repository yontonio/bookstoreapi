package com.example.resource;

import com.example.dao.AuthorDAO;
import com.example.dao.BookDAO;
import com.example.model.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
// Exposes REST endpoints for book operations.
public class BookResource {

    private final BookDAO   dao       = new BookDAO();
    private final AuthorDAO authorDAO = new AuthorDAO();
    // Returns all books.
    @GET
    // Returns all books.
    public List<Book> getAll() {
        return dao.getAll();
    }

    // Returns specific book
    @GET
    @Path("/{id}")
    public Book get(@PathParam("id") int id) {
        Book book = dao.get(id);
        if (book == null)
            throw new BookNotFoundException("Book not found with ID " + id);
        return book;
    }

    // Creates a new book.
    @POST
    public Response add(Book book) {
        if (book == null)
            throw new InvalidInputException("Book cannot be null.");
        if (book.getTitle() == null || book.getTitle().trim().isEmpty())
            throw new InvalidInputException("Book title cannot be empty.");
        if (authorDAO.get(book.getAuthorId()) == null)
            throw new AuthorNotFoundException("Author not found with ID " + book.getAuthorId());

        Book created = dao.add(book);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    // Updates an existing book.
    @PUT
    @Path("/{id}")
    public Book update(@PathParam("id") int id, Book book) {
        Book updated = dao.update(id, book);
        if (updated == null)
            throw new BookNotFoundException("Book not found with ID " + id);
        return updated;
    }

    // Deletes a specific book.
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Book removed = dao.delete(id);
        if (removed == null)
            throw new BookNotFoundException("Book not found with ID " + id);
        return Response.noContent().build(); 
    }
}
