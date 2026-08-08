package com.sinuke.easy;

public class MakeArrayZeroBySubtractingEqualAmounts {

    public int minimumOperations(int[] nums) {
        int[] f = new int[101];
        int cnt = 0;
        for (int num : nums) {
            if (num != 0 && f[num] == 0) {
                f[num] = 1;
                cnt++;
            }
        }
        return cnt;
    }

}