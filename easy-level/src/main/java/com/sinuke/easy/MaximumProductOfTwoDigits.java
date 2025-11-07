package com.sinuke.easy;

public class MaximumProductOfTwoDigits {

    public int maxProduct(int n) {
        int d1 = 0, d2 = 0;

        while (n > 0) {
            int d = n % 10;
            if (d >= d1) {
                d2 = d1;
                d1 = d;
            } else if (d >= d2) d2 = d;
            n /= 10;
        }

        return d1 * d2;
    }

}
