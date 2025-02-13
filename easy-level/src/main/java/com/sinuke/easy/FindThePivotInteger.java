package com.sinuke.easy;

public class FindThePivotInteger {

    public int pivotInteger(int n) {
        double x = Math.sqrt(((double) (n * n + n)) / 2);
        return (x % 1 == 0) ? (int) x : -1;
    }

}
