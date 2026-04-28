package com.sinuke.easy;

public class ValidDigitNumber {

    public boolean validDigit(int n, int x) {
        boolean found = false;
        int last = n % 10;
        while (n > 0) {
            int d = n % 10;
            if (d == x) found = true;
            last = d;
            n /= 10;
        }
        return found && last != x;
    }

}
