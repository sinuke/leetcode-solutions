package com.sinuke.easy;

public class MinimumAmountOfTimeToFillCups {

    public int fillCups(int[] amount) {
        int cnt = 0;
        while (amount[0] > 0 || amount[1] > 0 || amount[2] > 0) {
            int max = Math.max(amount[0], Math.max(amount[1], amount[2]));
            int min = Math.min(amount[0], Math.min(amount[1], amount[2]));
            int mid = amount[0] + amount[1] + amount[2] - min - max;

            amount[0] = max - 1;
            amount[1] = mid - 1;
            amount[2] = min;

            cnt++;
        }
        return cnt;
    }

}
