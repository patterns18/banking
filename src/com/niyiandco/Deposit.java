package com.niyiandco;

import java.math.BigDecimal;
import java.util.Date;

import static com.niyiandco.Transaction.TransactionType.DEPOSIT;

public class Deposit implements Transaction {

    Account targetAccount;
    Date date;
    BigDecimal amount;

    public Deposit(Account targetAccount, Date date, BigDecimal amount) {
        this.targetAccount = targetAccount;
        this.date = date;
        this.amount = amount;
    }

    public Transaction.TransactionType getType(){
        return DEPOSIT;
    }

    public Date getDate(){
        return date;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public Account getTargetAccount(){
        return targetAccount;
    }


//(and similar for Deposit and Withdrawal)
}
