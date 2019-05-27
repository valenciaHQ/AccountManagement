package com.avalencia.transactions.resources;

import com.avalencia.transactions.exception.NegativeAmountException;
import com.avalencia.transactions.model.Transaction;
import com.avalencia.transactions.services.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "Account")
@Path(value = "/account")
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value="Returns account information")
    @GET
    public Response getAccountData(){
        return Response.ok(accountService.getInformation(), MediaType.APPLICATION_JSON_TYPE).build();
    }

    @ApiOperation(value="Creates a debit transaction")
    @POST
    @Path(value = "/transaction/debit")
    public Response debit(@Valid Transaction transaction) throws NegativeAmountException {
        accountService.debit(transaction);
        return Response.status(Response.Status.OK).build();
    }

    @ApiOperation(value="Creates a credit transaction")
    @POST
    @Path(value = "/transaction/credit")
    public Response credit(Transaction transaction){
        accountService.credit(transaction);
        return Response.status(Response.Status.OK).build();
    }
}
