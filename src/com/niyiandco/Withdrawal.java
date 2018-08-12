package com.niyiandco;

import java.math.BigDecimal;
import java.util.Date;

import static com.niyiandco.Transaction.TransactionType.WITHDRAWAL;

public class Withdrawal implements Transaction {

    Account targetAccount;
    Date date;
    BigDecimal amount;

    public Withdrawal(Account targetAccount, Date date, BigDecimal amount) {
        this.targetAccount = targetAccount;
        this.date = date;
        this.amount = amount;
    }

    public Transaction.TransactionType getType() {
        return WITHDRAWAL;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

}
