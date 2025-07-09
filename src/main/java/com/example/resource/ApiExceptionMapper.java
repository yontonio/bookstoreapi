package com.example.resource;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
// Exposes REST endpoints for apiexceptionmapper operations.
public class ApiExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    // Performs toResponse operation.
    public Response toResponse(Exception ex) {
        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;
        String          msg    = ex.getMessage();
        if (ex instanceof NotFoundException
            || ex instanceof BookNotFoundException
            || ex instanceof AuthorNotFoundException
            || ex instanceof CustomerNotFoundException
            || ex instanceof CartNotFoundException
            || ex instanceof OrderNotFoundException) {
            status = Response.Status.NOT_FOUND;

        } else if (ex instanceof BadRequestException
                   || ex instanceof InvalidInputException
                   || ex instanceof OutOfStockException) {
            status = Response.Status.BAD_REQUEST;

        } else if (ex instanceof WebApplicationException) {
            status = Response.Status.fromStatusCode(
                         ((WebApplicationException) ex)
                         .getResponse().getStatus());
            if (msg == null || msg.isBlank()) {
                msg = status.getReasonPhrase();
            }
        } else {
            msg = "An unexpected error occurred.";
        }
        ErrorMessage body = new ErrorMessage(msg, status.getStatusCode());
        return Response.status(status)
                       .type(MediaType.APPLICATION_JSON)
                       .entity(body)
                       .build();
    }
}
