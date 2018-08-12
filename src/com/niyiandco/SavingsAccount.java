package com.niyiandco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SavingsAccount implements Account {

    String accountHolder;
    String accountNumber;
    BigDecimal sourceAccountBalance;
    BigDecimal targetAccountBalance;
    List<Transaction> transactions;

    public SavingsAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.sourceAccountBalance = new BigDecimal(0.0);
        this.targetAccountBalance = new BigDecimal(0.0);
    }

    @Override
    public String getAccountHolder() {
        return accountHolder;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public BigDecimal getAccountBalance() {
        return sourceAccountBalance;
    }

    public void addTransaction(Transaction transaction) {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);

        if (transaction instanceof Deposit) {
            System.out.println("Deposit not allowed on Savings");
        } else if (transaction instanceof Withdrawal) {
            System.out.println("Withdrawal not allowed on Saving");
        } else if (transaction instanceof Transfer) {
            sourceAccountBalance = sourceAccountBalance.subtract((transaction).getAmount());
            targetAccountBalance = targetAccountBalance.add((transaction).getAmount());
        } else if (transaction instanceof InterestPayment) {
            sourceAccountBalance = sourceAccountBalance.add((transaction).getAmount());
        }

    }
    public String printTransactions() {
        StringBuilder sb = new StringBuilder();
        for (Transaction trans : transactions) {
            String printLine = String.format("%tD : %s : $%.2f\n",
                    trans.getDate(),
                    trans.getType(),
                    trans.getAmount());
            sb.append(printLine);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("Savings account %s : %s : $%.2f",
                getAccountNumber(),
                getAccountHolder(),
                getAccountBalance());

    }


}
