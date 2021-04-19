package com.atqc.oop;

public class AccountException extends Exception {

    long balance;
    boolean status;

    public AccountException(String message, long balance) {
        super(message);
        this.balance = balance;
    }

    public AccountException(String message, boolean status) {
        super(message);
        this.status = status;
    }
}
