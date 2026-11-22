package com.sinuke.easy;

public class CountConsistentSubarraysI {

    public int countConsistent(int[] nums) {
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            int b = nums[i];
            int min = 101;

            for (int j = i; j < nums.length; j++) {
                b &= nums[j];
                min = Math.min(min, nums[j]);
                if (b == min) cnt++;
            }
        }

        return cnt;
    }

}
