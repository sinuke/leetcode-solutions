package com.sinuke.easy;

public class SumOfUniqueElements {

    public int sumOfUnique(int[] nums) {
        int[] dp = new int[101];
        int sum = 0;

        for (int num : nums) {
            if (dp[num] == 0) sum += num;
            else if (dp[num] == 1) sum -= num;
            dp[num]++;
        }

        return sum;
    }

}
