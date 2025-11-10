package com.sinuke.easy;

public class MinimumDistanceBetweenThreeEqualElementsI {

    public int minimumDistance(int[] nums) {
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] == nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] == nums[j]) dist = Math.min(dist, Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i));
                    }
                }
            }
        }
        return dist == Integer.MAX_VALUE ? - 1 : dist;
    }

}
