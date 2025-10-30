package com.sinuke.easy;

public class FindTheLeastFrequentDigit {

    public int getLeastFrequentDigit(int n) {
        int[] d = new int[10];
        while (n > 0) {
            d[n % 10]++;
            n /= 10;
        }
        int p = -1, freq = Integer.MAX_VALUE;
        for (int i = 1; i < 10; i++) {
            if (d[i] > 0 && d[i] < freq) {
                freq = d[i];
                p = i;
            }
        }
        return p;
    }

}
