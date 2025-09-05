package com.sinuke.medium;

public class PowXN {

    public double myPow(double x, int n) {
        long p = n;
        if (n < 0) {
            x = 1 / x;
            p = -p;
        }
        double result = 1.0;
        while (p > 0) {
            if (p % 2 == 1) result *= x;
            x *= x;
            p /= 2;
        }

        return result;
    }

}
