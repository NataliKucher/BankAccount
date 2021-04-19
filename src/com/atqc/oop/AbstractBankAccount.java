package com.atqc.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBankAccount<T> implements Account {

    // Defining the properties using generics <T>, enum, collection
    protected T ACCOUNT_NUMBER;
    protected Currency currency;
    protected long balance;
    protected boolean status;
    protected List<String> transactions = new ArrayList<>();

    // Constructor
    AbstractBankAccount(T accountNumber, Currency currency, boolean status) {
        this.ACCOUNT_NUMBER = accountNumber;
        this.currency = currency;
        this.status = status;
        //default value for type long: this.balance = 0; boolean: this.status = false;
    }

    public AbstractBankAccount() {
    }

    // Getters and Setters
    public T getAccountNumber() {
        return ACCOUNT_NUMBER;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void accountCurrency(Currency currency) {
        System.out.println(currency.name());
    }

    @Override
    public void printAccountInfo() {
        String info = toString();
        System.out.println(info);
    }

    @Override
    public void printTransactions() {
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void closeAccount() throws AccountException {
        if (getBalance() > 0)
            throw new AccountException(
                    String.format("Before closing your Account, Withdraw all your money please! Current balance: %d", balance),
                    balance);
        else {
            System.out.println("Your account is closed!");
        }
    }
}

