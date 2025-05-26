package com.sinuke.easy;

public class FindLuckyIntegerInArray {

    public int findLucky(int[] arr) {
        int[] dp = new int[501];
        for (int num : arr) dp[num]++;
        int max = -1;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == i && i > max) max = i;
        }
        return max;
    }

}
