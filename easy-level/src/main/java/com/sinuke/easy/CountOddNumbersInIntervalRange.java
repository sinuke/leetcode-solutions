package com.sinuke.easy;

public class CountOddNumbersInIntervalRange {

    public int countOdds(int low, int high) {
        int n = high - low + 1;
        if (n % 2 == 0) return n / 2;
        else return high % 2 != 0 || low % 2 != 0 ? (n / 2) + 1 : n / 2;
    }

}
