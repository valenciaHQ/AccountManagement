package com.avalencia.transactions.provider;

import com.avalencia.transactions.exception.NegativeAmountException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NegativeAmountExceptionMapper implements ExceptionMapper<NegativeAmountException> {
    @Override
    public Response toResponse(NegativeAmountException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
