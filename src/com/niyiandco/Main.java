package com.niyiandco;

import java.math.BigDecimal;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Account tosin = new CurrentAccount("Tosin", "00123456");

        System.out.println("Account to string");
        System.out.println( tosin.toString());

        Transaction deposit = new Deposit(tosin, new Date(), new BigDecimal(5000.0));
       tosin.addTransaction(deposit);

        System.out.println("Account to string");
        System.out.println( tosin.toString());

       tosin.addTransaction(new  Deposit(tosin, new Date(), new BigDecimal(600.0)));

        System.out.println("Account to string");
        System.out.println( tosin.toString());

        System.out.println("Print transactions");
        System.out.println(tosin.printTransactions());
    }
}
