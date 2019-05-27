package com.avalencia.transactions.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel
public class Account implements Serializable {

    public Account() {
    }

    public Account(double amount, List<Transaction> transactions) {
        this.amount = amount;
        this.transactions = transactions;
    }

    @ApiModelProperty
    private double amount;

    @ApiModelProperty
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
