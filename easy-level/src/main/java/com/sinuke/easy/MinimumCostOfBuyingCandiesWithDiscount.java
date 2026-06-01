package com.sinuke.easy;

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int cst = cost[cost.length - 1], i = cost.length - 2, cnt = 1;
        while (i >= 0) {
            if (cnt == 2) cnt = 0;
            else {
                cnt++;
                cst += cost[i];
            }

            i--;
        }
        return cst;
    }

}
