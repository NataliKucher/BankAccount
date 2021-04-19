package com.atqc.oop;

public interface Account {
    void deposit(long sum);

    void withdraw(long sum) throws AccountException;

    void printAccountInfo();

    void printBalance();

    void printTransactions();

    void closeAccount() throws AccountException;
}
