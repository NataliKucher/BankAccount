package com.atqc.oop;

public class App {

    public static void main(String[] args) throws AccountException {

        test_individual_account_transactions();
        test_close_individual_account();

        test_negative_transactions_with_closed_account();
        test_negative_withdraw_from_empty_account();
        test_negative_close_not_empty_account();

        test_business_account_transactions();
        test_close_business_account();
    }

    private static void test_individual_account_transactions() throws AccountException {
        Account individual = new IndividualAccount(
                "IBAN67345678912345", Currency.USD, true, "Kucheriava Nataliia");

        individual.printAccountInfo();
        // deposit money
        individual.deposit(3_000_000);
        individual.printBalance();
        // withdraw money
        individual.withdraw(1_000_000);
        individual.printBalance();
        // print all Transactions
        individual.printTransactions();
    }

    private static void test_close_individual_account() throws AccountException {
        Account individual = new IndividualAccount(
                "IBAN456345778912345", Currency.USD, true, "TestClose Individual");

        individual.closeAccount();
    }

    private static void test_negative_transactions_with_closed_account() {
        Account individual = new IndividualAccount();
        individual.printAccountInfo();
        // can't withdraw money from Account with status: false, balance: 0
        try {
            individual.withdraw(1_000_000);
        } catch (AccountException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        // can't deposit money to Account with status: false
        individual.deposit(1_000_000);
    }

    private static void test_negative_withdraw_from_empty_account() {
        Account individual = new IndividualAccount(
                "IBAN12345678912345", Currency.UAH, true, "TestWithdraw Negative");
        individual.printAccountInfo();
        // can't withdraw money from Account with status: false, balance: 0
        try {
            individual.withdraw(1_000_000);
        } catch (AccountException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    private static void test_negative_close_not_empty_account() throws AccountException {
        Account individual = new IndividualAccount(
                "IBAN456345778912345", Currency.USD, true, "TestClose Negative");
        individual.deposit(1_000_000);

        try {
            individual.closeAccount();
        } catch (AccountException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    private static void test_business_account_transactions() throws AccountException {
        Account business = new BusinessAccount(
                123456789123345L, Currency.EUR, true, "Yalantis");
        business.printAccountInfo();

        // deposit money
        business.deposit(3_000_000);
        business.printBalance();
        // withdraw money
        business.withdraw(1_000_000);
        business.printBalance();
        // print all Transactions
        business.printTransactions();
    }

    private static void test_close_business_account() throws AccountException {
        Account business = new BusinessAccount(
                123456789123345L, Currency.EUR, true, "TestClose Business");
        business.closeAccount();
    }
}
