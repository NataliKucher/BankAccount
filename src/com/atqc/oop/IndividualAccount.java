package com.atqc.oop;

public class IndividualAccount extends AbstractBankAccount<String> {

    private String userName;

    IndividualAccount(String accountNumber, Currency currency, boolean status, String userName) {
        super(accountNumber, currency, status);
        this.userName = userName;
    }

    public IndividualAccount() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return String.format("Person: %s   Account number: %s   Balance: %d   Currency: %s", userName, getAccountNumber(), getBalance(), currency);
    }

    @Override
    public void deposit(long sum) {
        if (getStatus()) {
            setBalance(getBalance() + sum);
            transactions.add(String.format("[Individual account] Deposit transaction\n Amount: %d", sum));
        } else {
            System.out.println("Sorry! We can not deposit money in closed account!");
        }
    }

    @Override
    public void withdraw(long sum) throws AccountException {
        if (getStatus()) {
            if (getBalance() >= sum) {
                setBalance(getBalance() - sum);
                transactions.add(String.format("[Individual account] Withdraw transaction\n Amount: %f, Fee: %f", sum * 0.9, sum * 0.1));
            } else {
                throw new AccountException(String.format("Sorry! You do not have this amount of money! Current balance: %d", balance), balance);
            }
        } else {
            throw new AccountException(String.format("Sorry! We can not withdraw money from closed account! Account status: %s", status), status);
        }
    }

    public void printBalance() {
        System.out.printf("Your Individual account balance: %d %s\n", getBalance(), currency);
    }
}
