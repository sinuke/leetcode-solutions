package com.sinuke.easy;

public class SumOfIntegersWithMaximumDigitRange {

    public int maxDigitRange(int[] nums) {
        int[] ranges = new int[10];
        int max = -1;
        for (int num : nums) {
            int d = getDiff(num);
            max = Math.max(max, d);
            ranges[d] += num;
        }
        return ranges[max];
    }

    private int getDiff(int num) {
        int max = -1, min = 10;
        while (num > 0) {
            int d = num % 10;
            max = Math.max(max, d);
            min = Math.min(min, d);
            num /= 10;
        }
        return max - min;
    }

}
