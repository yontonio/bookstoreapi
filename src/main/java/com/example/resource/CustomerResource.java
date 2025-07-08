package com.example.resource;

import com.example.dao.CustomerDAO;
import com.example.model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
// Exposes REST endpoints for customer operations.
public class CustomerResource {

    private final CustomerDAO dao = new CustomerDAO();
    // Returns all customers.
    @GET
    public List<Customer> getAll() {
        return dao.getAll();
    }

    // Returns specific customer.
    @GET
    @Path("/{id}")
    public Customer get(@PathParam("id") int id) {
        Customer c = dao.get(id);
        if (c == null)
            throw new CustomerNotFoundException("Customer not found with ID " + id);
        return c;
    }

    // Creates a new customer.
    @POST
    public Response add(Customer customer) {
        if (customer.getName()  == null || customer.getName().trim().isEmpty())
            throw new InvalidInputException("Customer name is required.");
        if (customer.getEmail() == null || customer.getEmail().trim().isEmpty())
            throw new InvalidInputException("Customer email is required.");

        Customer created = dao.add(customer);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    // Updates an existing customer.
    @PUT
    @Path("/{id}")
    public Customer update(@PathParam("id") int id, Customer customer) {
        Customer updated = dao.update(id, customer);
        if (updated == null)
            throw new CustomerNotFoundException("Customer not found with ID " + id);
        return updated;
    }

    // Deletes a specific customer.
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Customer removed = dao.delete(id);
        if (removed == null)
            throw new CustomerNotFoundException("Customer not found with ID " + id);
        return Response.noContent().build();         
    }
}
