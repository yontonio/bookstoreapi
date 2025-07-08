package com.example.resource;

import com.example.dao.CartDAO;
import com.example.dao.OrderDAO;
import com.example.model.CartItem;
import com.example.model.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers/{customerId}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
// Exposes REST endpoints for order operations.
public class OrderResource {

    private final OrderDAO orderDAO = new OrderDAO();
    private final CartDAO  cartDAO  = new CartDAO();

    // Creates a new order using the items from the customers cart.
    @POST
    public Response create(@PathParam("customerId") int customerId) {
        List<CartItem> items = cartDAO.getCart(customerId);
        if (items == null || items.isEmpty())
            throw new CartNotFoundException("Cart empty for customer " + customerId);

        Order order = orderDAO.add(customerId, items);
        cartDAO.clearCart(customerId);

        return Response.status(Response.Status.CREATED).entity(order).build();
    }

    // Returns all orders made by a specific customer.
    @GET
    public List<Order> getOrders(@PathParam("customerId") int customerId) {
        return orderDAO.getAll(customerId);
    }

    // Returns a specific order from a customer.
    @GET
    @Path("/{orderId}")
    public Order getOrder(@PathParam("customerId") int customerId,
                          @PathParam("orderId")     int orderId) {
        Order o = orderDAO.get(customerId, orderId);
        if (o == null)
            throw new OrderNotFoundException("Order " + orderId +
                                             " not found for customer " + customerId);
        return o;
    }
}
