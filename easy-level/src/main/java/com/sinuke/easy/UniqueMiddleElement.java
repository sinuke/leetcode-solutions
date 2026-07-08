package com.sinuke.easy;

public class UniqueMiddleElement {

    public boolean isMiddleElementUnique(int[] nums) {
        int[] f = new int[101];
        for (int num : nums) f[num]++;
        return f[nums[nums.length / 2]] == 1;
    }

}
