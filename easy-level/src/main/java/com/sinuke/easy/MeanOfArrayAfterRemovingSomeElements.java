package com.sinuke.easy;

import java.util.Arrays;

public class MeanOfArrayAfterRemovingSomeElements {

    // 14 ms
    public double trimMean2(int[] arr) {
        int n = arr.length;
        return Arrays.stream(arr)
                .sorted()
                .skip(n / 20)
                .limit(n - n / 10)
                .average()
                .getAsDouble();
    }

    // 6 ms
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long sum = 0;
        for (int i = (n / 20); i < n - n / 20; i++) {
            sum += arr[i];
        }
        return (sum / (double) (n - n / 10));
    }

}
