package com.sinuke.easy;

public class MinimumCostToReachEveryPosition {

    public int[] minCosts(int[] cost) {
        int min = cost[0];
        int[] ans = new int[cost.length];
        for (int i = 0; i < cost.length; i++) {
            min = Math.min(min, cost[i]);
            ans[i] = min;
        }
        return ans;
    }

}
