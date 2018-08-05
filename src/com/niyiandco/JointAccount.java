package com.niyiandco;

public interface JointAccount extends Account {

        public String getSecondAccountHolder();

        /**
         * Return the account type, the account number, the account holders, and all
         * transactions on this account
         *
         * @return account output
         */
        @Override
        public String toString();


}
