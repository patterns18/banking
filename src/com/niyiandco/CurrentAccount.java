package com.niyiandco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CurrentAccount implements Account {

    String accountHolder;
    String accountNumber;
    BigDecimal sourceAccountBalance;
    BigDecimal targetAccountBalance;
    List<Transaction> transactions;

    public CurrentAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.sourceAccountBalance = new BigDecimal(0);
        this.targetAccountBalance = new BigDecimal(0);
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return sourceAccountBalance;
    }

    /**
     * Add transaction to the account.
     *
     * @param transaction
     * @throws RuntimeException if transaction does not use this account or transaction is
     *                          not valid for this type of account.
     */
    public void addTransaction(Transaction transaction) {
        if (!(transaction instanceof InterestPayment)) {
            if (transactions == null) {
                transactions = new ArrayList<>();
            }
            transactions.add(transaction);
            if (transaction instanceof Deposit) {
                sourceAccountBalance = sourceAccountBalance.add(((Deposit) transaction).getAmount());
            } else if (transaction instanceof Withdrawal) {
                sourceAccountBalance = sourceAccountBalance.subtract(((Withdrawal) transaction).amount);
            } else if (transaction instanceof Transfer) {
                sourceAccountBalance = sourceAccountBalance.subtract(((Transfer) transaction).amount);
                targetAccountBalance = targetAccountBalance.add(((Transfer) transaction).amount);
            }
        }
        if (transaction instanceof InterestPayment) {
            System.out.println("Interest Payment can't be applied on Current Account");
        }
    }


    /**
     * Return a string containing all the transactions of this account
     *
     * @return transaction output
     */

    public String printTransactions() {
//16/01/2016 : DEPOSIT : £20.50
        StringBuilder sb = new StringBuilder();
        for (Transaction trans : transactions) {
            String printLine = String.format("%tD : %s : $%.2f\n", trans.getDate(), trans.getType(), trans.getAmount());
            sb.append(printLine);
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return String.format("Current account %s : %s : $%.2f",
                getAccountNumber(),
                getAccountHolder(),
                getAccountBalance());
    }
}
