package com.niyiandco;

import java.math.BigDecimal;

public interface Account {

        public String getAccountHolder();

        public String getAccountNumber();

        /**
         * The current balance of the account, calculated from the transactions
         * applied to the account
         *
         * @return balance of account
         */
        public BigDecimal getAccountBalance();

        /**
         * Add transaction to the account.
         *
         * @param transaction
         * @throws RuntimeException
         *             if transaction does not use this account or transaction is
         *             not valid for this type of account.
         */
        public void addTransaction(Transaction transaction);

        /**
         * Return a string containing all the transactions of this account
         *
         * @return transaction output
         */
        public String printTransactions();

        /**
         * Return the account type, the account number, the account holder, and
         * balance on this account
         *
         * @return account output
         */
        @Override
        public String toString();


}
