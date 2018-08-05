package com.niyiandco;

import java.math.BigDecimal;
import java.util.Date;

public interface Transaction {

        static enum TransactionType {
            DEPOSIT,
            WITHDRAWAL,
            TRANSFER,
            INTEREST_PAYMENT,
        }

        TransactionType getType();

        Date getDate();

        BigDecimal getAmount();

        Account getTargetAccount();

}
