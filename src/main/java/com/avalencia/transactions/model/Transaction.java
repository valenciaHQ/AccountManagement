package com.avalencia.transactions.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class Transaction implements Serializable {

    public Transaction() {
    }

    public Transaction(double amount) {
        this.amount = amount;
    }

    @ApiModelProperty
    private double amount;

    @ApiModelProperty
    private TransactionTypes type;

    @ApiModelProperty
    private String createDate;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public TransactionTypes getType() {
        return type;
    }

    public void setType(TransactionTypes type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
