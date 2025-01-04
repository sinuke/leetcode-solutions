package com.sinuke.easy;

public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }

            maxWealth = Math.max(maxWealth, sum);
        }

        return maxWealth;
    }

}
