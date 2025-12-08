package com.sinuke.easy;

public class CountSquareSumTriples {

    public int countTriples(int n) {
        int count = 0;
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                int cc = a * a + b * b;
                int c = (int) Math.sqrt(cc);
                if (cc == c * c && c <= n) count++;
            }
        }
        return count;
    }

}
