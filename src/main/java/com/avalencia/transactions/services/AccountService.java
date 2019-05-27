package com.avalencia.transactions.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;
import com.avalencia.transactions.exception.NegativeAmountException;
import com.avalencia.transactions.model.Account;
import com.avalencia.transactions.model.Transaction;
import com.avalencia.transactions.model.TransactionTypes;

@Service
public class AccountService {

    private Account account;

    public AccountService() {
        account = new Account(0, new ArrayList<>());
    }

    public Account getInformation() {
        return getAccount();
    }

    public void debit(Transaction transaction) throws NegativeAmountException {
        transaction.setType(TransactionTypes.DEBIT);
        double result = getAccount().getAmount() - transaction.getAmount();
        if (result < 0) {
            throw new NegativeAmountException();
        }
        getAccount().setAmount(result);
        addTransactionHistory(transaction);
    }

    public void credit(Transaction transaction) {
        transaction.setType(TransactionTypes.CREDIT);
        getAccount().setAmount(getAccount().getAmount() + transaction.getAmount());
        addTransactionHistory(transaction);
    }

    private void addTransactionHistory(Transaction transaction) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        transaction.setCreateDate(sdf.format(date));
        getAccount().getTransactions().add(transaction);
    }

    public Account getAccount() {
        return account;
    }
}
