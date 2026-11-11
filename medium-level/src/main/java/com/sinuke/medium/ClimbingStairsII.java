package com.sinuke.medium;

public class ClimbingStairsII {

    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            int i = Math.max(j - 3, 0);
            int min = Integer.MAX_VALUE;
            while (i < j) {
                min = Math.min(dp[i] + costs[j - 1] + (j - i) * (j - i), min);
                i++;
            }
            dp[j] = min;
        }
        return dp[n];
    }

}
