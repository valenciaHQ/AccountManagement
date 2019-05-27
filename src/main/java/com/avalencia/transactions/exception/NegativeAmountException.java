package com.avalencia.transactions.exception;

public class NegativeAmountException extends Exception {

    public NegativeAmountException(){
        super("This transaction will not be processed. Insufficient account funds");
    }
}
