package com.sinuke.easy;

public class TransformedArray {

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) ans[i] = nums[(i + nums[i]) % n];
            else if (nums[i] < 0) ans[i] = nums[(i + n + (nums[i] % n)) % n];
        }
        return ans;
    }

}
