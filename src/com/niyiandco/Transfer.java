package com.niyiandco;

import java.math.BigDecimal;
import java.util.Date;

import static com.niyiandco.Transaction.TransactionType.TRANSFER;

public class Transfer implements Transaction {

    Account sourceAccount;
    Account targetAccount;
    Date date;
    BigDecimal amount;

    public Transfer(Account sourceAccount, Account targetAccount, Date date, BigDecimal amount) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.date = date;
        this.amount = amount;
    }

    public Transaction.TransactionType getType() {
        return TRANSFER;
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

    public Account getSourceAccount() {
        return sourceAccount;
    }

}
