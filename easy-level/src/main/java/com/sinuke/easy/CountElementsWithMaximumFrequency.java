package com.sinuke.easy;

public class CountElementsWithMaximumFrequency {

    public int maxFrequencyElements(int[] nums) {
        int max = Integer.MIN_VALUE, result = 0;
        int[] dp = new int[101];
        for (int num : nums) {
            int count = dp[num] + 1;
            dp[num] = count;
            if (count > max) {
                max = count;
                result = 1;
            } else if (count == max) result++;
        }
        return result * max;
    }

}
