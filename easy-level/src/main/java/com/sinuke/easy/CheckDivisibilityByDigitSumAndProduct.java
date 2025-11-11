package com.sinuke.easy;

public class CheckDivisibilityByDigitSumAndProduct {

    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1, num = n;
        while (n > 0) {
            int d = n % 10;
            sum += d;
            product *= d;
            n /= 10;
        }
        return num % (product + sum) == 0;
    }

}
