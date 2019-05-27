package com.avalencia.transactions.exception;

import java.io.Serializable;

public class NegativeAmountException extends Exception implements Serializable {

    public NegativeAmountException(){
        super("This transaction will not be processed. Insufficient account funds");
    }
}
