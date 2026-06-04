package com.sinuke.medium;

import java.util.Arrays;
import java.util.Comparator;

class MostProfitAssigningWork {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int[][] dp = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            dp[i][0] = difficulty[i];
            dp[i][1] = profit[i];
        }
        Arrays.sort(dp, Comparator.comparingInt(a -> a[0]));

        int result = 0, j = 0, max = -1;
        for (int k : worker) {
            while (j < dp.length && dp[j][0] <= k) max = Math.max(max, dp[j++][1]);
            if (max > 0) result += max;
        }
        return result;
    }

}
