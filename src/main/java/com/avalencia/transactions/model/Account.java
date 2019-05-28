package com.avalencia.transactions.model;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {

    public Account() {
    }

    public Account(double amount, List<Transaction> transactions) {
        this.amount = amount;
        this.transactions = transactions;
    }

    private double amount;

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
