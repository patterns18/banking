package com.niyiandco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CurrentAccount implements Account {

    String accountHolder;
    String accountNumber;
    BigDecimal accountBalance;
    List<Transaction> transactions;

    public CurrentAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountBalance = new BigDecimal(0);
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public BigDecimal getAccountBalance(){
        return accountBalance;
    }

    /**
     * Add transaction to the account.
     *
     * @param transaction
     * @throws RuntimeException
     *             if transaction does not use this account or transaction is
     *             not valid for this type of account.
     */
    public void addTransaction(Transaction transaction) {
        if(transactions == null){
            transactions = new ArrayList<>();
        }

        transactions.add(transaction);

        if(transaction instanceof  Deposit){
            accountBalance = accountBalance.add(((Deposit) transaction).amount);
        }else if(transaction instanceof Withdrawal){
            accountBalance = accountBalance.subtract(((Withdrawal) transaction).amount);
        }
    }


    /**
     * Return a string containing all the transactions of this account
     *
     * @return transaction output
     */

    public String printTransactions(){
//16/01/2016 : DEPOSIT : £20.50
        StringBuilder sb = new StringBuilder();

        for(Transaction trans:transactions){
            String printLine = String.format("%tD : %s : $%f.2\n", trans.getDate(), trans.getType(), trans.getAmount());
            sb.append(printLine);
        }
         return sb.toString();

    }

    /**
     * Return the account type, the account number, the account holder, and
     * balance on this account
     *
     * @return account output
     */
    @Override
    public String toString(){
            return String.format("Current account %s : %s : $%f.2",
                getAccountNumber(),
                getAccountHolder(),
                getAccountBalance());
    }



}
