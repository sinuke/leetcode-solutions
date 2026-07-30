package com.sinuke.easy;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[cost.length - 1] = cost[cost.length - 1];
        for (int i = cost.length - 2; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }

        return Math.min(dp[0], dp[1]);
    }

}
