package com.avalencia.transactions.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.avalencia.transactions.exception.NegativeAmountException;
import com.avalencia.transactions.model.ApiError;

@Provider
public class NegativeAmountExceptionMapper implements ExceptionMapper<NegativeAmountException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(NegativeAmountException e) {
        ApiError error = new ApiError(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
