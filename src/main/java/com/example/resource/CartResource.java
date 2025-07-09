package com.example.resource;

import com.example.dao.CartDAO;
import com.example.dao.BookDAO;
import com.example.model.CartItem;
import com.example.model.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/customers/{customerId}/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
// Exposes REST endpoints for cart operations.
public class CartResource {
    private final CartDAO dao = new CartDAO();
    private final BookDAO bookDAO = new BookDAO();

    // Returns a specific customers cart
    @GET
    public List<CartItem> getCart(@PathParam("customerId") int customerId) {
        List<CartItem> cart = dao.getCart(customerId);
        if (cart == null || cart.isEmpty()) {
            throw new CartNotFoundException("Cart for customer " + customerId + " not found or empty.");
        }
        return cart;
    }
    // Adds the specific book into the customers cart.
    @POST
    @Path("/items")
    public void addItem(@PathParam("customerId") int customerId, CartItem item) {
        Book book = bookDAO.get(item.getBookId());
        if (book == null) {
            throw new BookNotFoundException("Book not found with ID " + item.getBookId());
        }
        if (item.getQuantity() <= 0) {
            throw new InvalidInputException("Quantity must be greater than zero.");
        }
        dao.addItem(customerId, item);
    }

    // Updates a specific book from an existing customer.
    @PUT
    @Path("/items/{bookId}")
    public void updateItem(@PathParam("customerId") int customerId,
                           @PathParam("bookId") int bookId,
                           CartItem updatedItem) {
        if (updatedItem.getQuantity() <= 0) {
            throw new InvalidInputException("Quantity must be greater than zero.");
        }
        updatedItem.setBookId(bookId);
        boolean updated = dao.updateItem(customerId, updatedItem);
        if (!updated) {
            throw new CartNotFoundException("Cart or item not found for customer " + customerId);
        }
    }

    // Removes specific book from customer's cart.
    @DELETE
    @Path("/items/{bookId}")
    public void removeItem(@PathParam("customerId") int customerId,
                           @PathParam("bookId") int bookId) {
        boolean removed = dao.removeItem(customerId, bookId);
        if (!removed) {
            throw new CartNotFoundException("Item not found in cart for customer " + customerId);
        }
    }
}
