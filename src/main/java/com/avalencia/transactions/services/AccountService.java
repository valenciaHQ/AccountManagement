package com.avalencia.transactions.services;

import com.avalencia.transactions.exception.NegativeAmountException;
import com.avalencia.transactions.model.Account;
import com.avalencia.transactions.model.Transaction;
import com.avalencia.transactions.model.TransactionTypes;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class AccountService {

    private Account account;

    public AccountService(){
        account = new Account(0, new ArrayList<>());
    }

    public Account getInformation() {
        return getAccount();
    }

    public void debit(Transaction transaction) throws NegativeAmountException {
        transaction.setType(TransactionTypes.DEBIT);
        getAccount().setAmount(getAccount().getAmount() - transaction.getAmount());
        if(getAccount().getAmount()<0){
            throw new NegativeAmountException();
        }
        addTransactionHistory(transaction);
    }

    public void credit(Transaction transaction){
        transaction.setType(TransactionTypes.CREDIT);
        getAccount().setAmount(getAccount().getAmount() + transaction.getAmount());
        addTransactionHistory(transaction);
    }

    private void addTransactionHistory(Transaction transaction){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        transaction.setCreateDate(sdf.format(date));
        getAccount().getTransactions().add(transaction);
    }

    public Account getAccount() {
        return account;
    }
}
