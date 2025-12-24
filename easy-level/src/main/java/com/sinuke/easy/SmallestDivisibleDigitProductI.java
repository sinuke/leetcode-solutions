package com.sinuke.easy;

public class SmallestDivisibleDigitProductI {

    public int smallestNumber(int n, int t) {
        int prod = product(n);
        while (prod % t != 0) prod = product(++n);
        return n;
    }

    private int product(int n) {
        int prod = 1;
        while (n > 0) {
            prod *= n % 10;
            n /= 10;
        }
        return prod;
    }

}
