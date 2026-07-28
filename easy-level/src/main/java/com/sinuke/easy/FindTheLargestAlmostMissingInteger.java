package com.sinuke.easy;

public class FindTheLargestAlmostMissingInteger {

    public int largestInteger(int[] nums, int k) {
        int[] f = new int[51];
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            f[num]++;
        }

        if (k == nums.length) return max;

        int ans = -1;
        if (k == 1) {
            for (int i = max; i >= 0; i--) {
                if (f[i] == 1) {
                    ans = i;
                    break;
                }
            }
        } else {
            if (f[nums[0]] == 1 && f[nums[nums.length - 1]] == 1) ans = Math.max(nums[0], nums[nums.length - 1]);
            else if (f[nums[0]] == 1 && f[nums[nums.length - 1]] != 1) ans = nums[0];
            else if (f[nums[0]] != 1 && f[nums[nums.length - 1]] == 1) ans = nums[nums.length - 1];
        }

        return ans;
    }

}
