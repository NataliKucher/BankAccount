package com.atqc.oop;

public class BusinessAccount extends AbstractBankAccount<Long> {
    private String companyName;

    BusinessAccount(Long accountNumber, Currency currency, boolean status, String companyName) {
        super(accountNumber, currency, status);
        this.companyName = companyName;
    }

    public BusinessAccount() {
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return String.format("Company: %s   Account number: %s   Balance: %d   Currency: %s", companyName, getAccountNumber(), getBalance(), currency);
    }

    @Override
    public void deposit(long sum) {
        if (getStatus()) {
            setBalance(getBalance() + sum);
            transactions.add(String.format("[Business account] Deposit transaction\n Amount: %d", sum));
        } else {
            System.out.println("Sorry! We can not deposit money in closed account!");
        }
    }

    @Override
    public void withdraw(long sum) throws AccountException {
        if (getStatus()) {
            if (getBalance() >= sum) {
                setBalance(getBalance() - sum);
                transactions.add(String.format("[Business account] Withdraw transaction\n Amount: %f, Fee: %f", sum * 0.95, sum * 0.05));
            } else {
                throw new AccountException(String.format("Sorry! You do not have this amount of money! Current balance: %d", balance), balance);
            }
        } else {
            throw new AccountException(String.format("Sorry! We can not withdraw money from closed account! Account status: %s", status), status);
        }
    }

    @Override
    public void printBalance() {
        System.out.printf("Your Business account balance: %d %s\n", getBalance(), currency);
    }
}
