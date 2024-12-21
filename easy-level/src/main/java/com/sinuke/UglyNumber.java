package com.sinuke;

public class UglyNumber {

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                if (i != 2 && i != 3 && i != 5) return false;
                n /= i;
            }
        }

        return n <= 5;
    }

    public boolean isUglyLeetcode(int n) {
        if (n < 1) return false;

        while (n > 1) {
            if (n % 2 == 0) n /= 2;
            else if (n % 3 == 0) n /= 3;
            else if (n % 5 == 0) n /= 5;
            else return false;
        }

        return true;
    }

}
