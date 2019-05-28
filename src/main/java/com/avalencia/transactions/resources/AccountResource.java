package com.avalencia.transactions.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import com.avalencia.transactions.exception.NegativeAmountException;
import com.avalencia.transactions.model.Transaction;
import com.avalencia.transactions.services.AccountService;

@Path(value = "/account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @GET
    public Response getAccountData(){
        return Response.ok(accountService.getInformation(), MediaType.APPLICATION_JSON_TYPE).build();
    }

    @POST
    @Path(value = "/transaction/debit")
    public Response debit(Transaction transaction) throws NegativeAmountException {
        accountService.debit(transaction);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path(value = "/transaction/credit")
    public Response credit(Transaction transaction){
        accountService.credit(transaction);
        return Response.status(Response.Status.OK).build();
    }
}
