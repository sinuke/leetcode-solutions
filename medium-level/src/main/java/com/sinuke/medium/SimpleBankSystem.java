package com.sinuke.medium;

public class SimpleBankSystem {

    public static class Bank {

        private final long[] balance;
        private final int n;

        public Bank(long[] balance) {
            this.balance = balance;
            this.n = balance.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (check(account1, money) && check(account2)) {
                balance[account1 - 1]-= money;
                balance[account2 - 1] += money;
                return true;
            }

            return false;
        }

        public boolean deposit(int account, long money) {
            if (check(account)) {
                balance[account - 1] += money;
                return true;
            }

            return false;
        }

        public boolean withdraw(int account, long money) {
            if (check(account, money)) {
                balance[account - 1] -= money;
                return true;
            }

            return false;
        }

        private boolean check(int account) {
            return account >= 1 && account <= n;
        }

        private boolean check(int account, long money) {
            return check(account) && balance[account - 1] >= money;
        }
    }

}
