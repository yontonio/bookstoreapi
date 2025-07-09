package com.example.resource;

import com.example.model.Author;
import com.example.model.Book;
import com.example.dao.AuthorDAO;
import com.example.dao.BookDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import javax.ws.rs.core.Response;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
// Exposes REST endpoints for author operations.
public class AuthorResource {
    private final AuthorDAO dao = new AuthorDAO();
    
    @GET
    // Returns all authors.
    public List<Author> getAll() {
        return dao.getAll();
    }
    // Returns a specific author.
    @GET
    @Path("/{id}")
    public Author get(@PathParam("id") int id) {
        Author author = dao.get(id);
        if (author == null) throw new NotFoundException("Author not found with id " + id);
        return author;
    }

    // Creates a new author.
    @POST
public Response add(Author author) {
    if (author.getName() == null || author.getName().trim().isEmpty())
        throw new InvalidInputException("Author name is required.");
    Author created = dao.add(author);
    return Response.status(Response.Status.CREATED).entity(created).build();
}


    // Updates an existing author.
    @PUT
    @Path("/{id}")
    public Author update(@PathParam("id") int id, Author author) {
        if (dao.get(id) == null) throw new NotFoundException("Author not found.");
        if (author.getName() == null || author.getName().trim().isEmpty())
            throw new BadRequestException("Author name is required.");
        return dao.update(id, author);
    }

    // Deletes a specific author.
   @DELETE
@Path("/{id}")
public Response delete(@PathParam("id") int id) {
    Author removed = dao.delete(id);
    if (removed == null) {
        throw new AuthorNotFoundException("Author not found with ID " + id);
    }
    return Response.noContent().build(); 
}
    // Returns books by author
    @GET
    @Path("/{id}/books")
    public List<Book> getBooksByAuthor(@PathParam("id") int authorId) {
        BookDAO bookDAO = new BookDAO();
        List<Book> results = new ArrayList<>();
        for (Book book : bookDAO.getAll()) {
            if (book.getAuthorId() == authorId) {
                results.add(book);
            }
        }
        return results;
    }
}
