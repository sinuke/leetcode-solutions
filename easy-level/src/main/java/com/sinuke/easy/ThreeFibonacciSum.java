package com.sinuke.easy;

public class ThreeFibonacciSum {

    public boolean threeFibonacciSum(int n) {
        long x = n / 2;
        return n % 2 == 0 &&
                (isPerfectSquare(5 * x * x + 4) || isPerfectSquare(5 * x * x - 4));
    }

    private boolean isPerfectSquare(long n) {
        long root = (long) Math.sqrt(n);
        return root * root == n;
    }

}
