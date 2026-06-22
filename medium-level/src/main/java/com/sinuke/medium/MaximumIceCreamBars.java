package com.sinuke.medium;

import java.util.Arrays;

public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0, cnt = 0;
        while (i < costs.length && coins > 0 && coins >= costs[i]) {
            coins -= costs[i++];
            cnt++;
        }
        return cnt;
    }

}
