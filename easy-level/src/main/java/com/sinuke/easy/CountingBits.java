package com.sinuke.easy;

public class CountingBits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        if (n > 0) result[1] = 1;
        for (int i = 1; i <= n; i++) {
            result[i] = result[i / 2] + result[i % 2];
        }
        return result;
    }

}
