package com.atqc.oop;

public class App {

    public static void main(String[] args) throws AccountException {

        testIndividualAccountTransactions();
        testCloseIndividualAccount();

        testNegativeTransactionsWithClosedAccount();
        testNegativeWithdrawFromEmptyAccount();
        testNegativeCloseNotEmptyAccount();
        
        testBusinessAccountTransactions();
        testCloseBusinessAccount();
    }

    private static void testIndividualAccountTransactions() throws AccountException {
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

    private static void testCloseIndividualAccount() throws AccountException {
        Account individual = new IndividualAccount(
                "IBAN456345778912345", Currency.USD, true, "TestClose Individual");

        individual.closeAccount();
    }

    private static void testNegativeTransactionsWithClosedAccount() {
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

    private static void testNegativeWithdrawFromEmptyAccount() {
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

    private static void testNegativeCloseNotEmptyAccount() {
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

    private static void testBusinessAccountTransactions() throws AccountException {
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

    private static void testCloseBusinessAccount() throws AccountException {
        Account business = new BusinessAccount(
                123456789123345L, Currency.EUR, true, "TestClose Business");
        business.closeAccount();
    }
}
