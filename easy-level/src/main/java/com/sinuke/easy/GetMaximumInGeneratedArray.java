package com.sinuke.easy;

public class GetMaximumInGeneratedArray {

    public int getMaximumGenerated(int n) {
        int[] a = new int[n + 1];
        int max = a[0];
        if (n > 0) {
            a[1] = 1;
            max = a[1];
        }
        for (int i = 2; i < n + 1; i++) {
            a[i] = (i % 2 == 0) ? a[i / 2] : a[(i - 1) / 2] + a[(i - 1) / 2 + 1];
            max = Math.max(max, a[i]);
        }
        return max;
    }

}
