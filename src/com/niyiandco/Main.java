package com.niyiandco;

import java.math.BigDecimal;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        CurrentAccountTxn();
        SavingsAccountTxn();
    }

    static void CurrentAccountTxn() {
        Account tosin = new CurrentAccount("Tosin", "6160134457");
        Account dolapo = new CurrentAccount("Dolapo", "5050025969");

        System.out.println("Account to string");
        System.out.println(tosin.toString());

        Transaction deposit = new Deposit(tosin, new Date(), new BigDecimal(5000.0));
        tosin.addTransaction(deposit);

        System.out.println("Account to string");
        System.out.println(tosin.toString());

        tosin.addTransaction(new Deposit(tosin, new Date(), new BigDecimal(600.0)));

        System.out.println("Account to string");
        System.out.println(tosin.toString());

        tosin.addTransaction(new Withdrawal(tosin, new Date(), new BigDecimal(1600.0)));

        System.out.println("Account to string");
        System.out.println(tosin.toString());

        tosin.addTransaction(new Transfer(tosin, dolapo, new Date(), new BigDecimal(1600.0)));

        System.out.println("Print transactions");
        System.out.println(tosin.printTransactions());
    }

    static void SavingsAccountTxn() {
        Account tosin = new SavingsAccount("Tosin", "6160134457");
        Account dolapo = new SavingsAccount("Dolapo", "5050025969");

        System.out.println("Account to string");
        System.out.println(tosin.toString());

        Transaction deposit = new Deposit(tosin, new Date(), new BigDecimal(5000.0));
        tosin.addTransaction(deposit);

        System.out.println("Account to string");
        System.out.println(tosin.toString());

        tosin.addTransaction(new Deposit(tosin, new Date(), new BigDecimal(600.0)));

        System.out.println("Account to string");
        System.out.println(tosin.toString());

        tosin.addTransaction(new Withdrawal(tosin, new Date(), new BigDecimal(1600.0)));

        System.out.println("Account to string");
        System.out.println(tosin.toString());

        tosin.addTransaction(new InterestPayment(tosin, new Date(), new BigDecimal(3300.0)));

        System.out.println("Account to string");
        System.out.println(tosin.toString());

        tosin.addTransaction(new Transfer(tosin, dolapo, new Date(), new BigDecimal(300.0)));

        System.out.println(tosin.toString());
        System.out.println("Print transactions");
        System.out.println(tosin.printTransactions());
    }
}
