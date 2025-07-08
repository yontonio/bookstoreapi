
package com.example.resource;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Provider
// REST endpoints for genericexceptionmapper operations.
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    // Performs toResponse operation.
    public Response toResponse(Throwable ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getClass().getSimpleName());
        error.put("message", ex.getMessage());

        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;

        if (ex instanceof BookNotFoundException ||
            ex instanceof AuthorNotFoundException ||
            ex instanceof CustomerNotFoundException ||
            ex instanceof CartNotFoundException) {
            status = Response.Status.NOT_FOUND;
        }

        return Response.status(status)
                       .entity(error)
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }
}
