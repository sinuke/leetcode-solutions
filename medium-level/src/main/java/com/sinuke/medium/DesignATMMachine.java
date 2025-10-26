package com.sinuke.medium;

public class DesignATMMachine {

    public static class ATM {

        private final static int n = 5;
        private final static int[] empty = new int[]{-1};

        private final Banknote[] bank;

        public ATM() {
            bank = new Banknote[n];
            bank[0] = new Banknote(20);
            bank[1] = new Banknote(50);
            bank[2] = new Banknote(100);
            bank[3] = new Banknote(200);
            bank[4] = new Banknote(500);
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < n; i++) bank[i].count += banknotesCount[i];
        }

        public int[] withdraw(int amount) {
            int[] result = new int[n];
            int i = n - 1;
            while (i >= 0) {
                if (bank[i].count != 0) {
                    int needed = amount / bank[i].denomination;
                    if (needed > bank[i].count) needed = bank[i].count;
                    amount -= bank[i].denomination * needed;
                    result[i] = needed;
                }

                if (amount == 0) {
                    for (int k = 0; k < n; k++) bank[k].count -= result[k];
                    return result;
                }

                i--;
            }

            return empty;
        }

        private static class Banknote {
            int denomination;
            int count;

            Banknote(int denomination) {
                this.denomination = denomination;
            }
        }
    }

}
