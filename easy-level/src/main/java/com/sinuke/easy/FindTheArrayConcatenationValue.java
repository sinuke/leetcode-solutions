package com.sinuke.easy;

public class FindTheArrayConcatenationValue {

    public long findTheArrayConcVal(int[] nums) {
        int l = 0, r = nums.length - 1;
        long ans = 0;
        while (r - l > 0) ans += Long.parseLong(String.valueOf(nums[l++]) + String.valueOf(nums[r--]));
        if (r - l == 0) ans += Long.parseLong(String.valueOf(nums[l]));
        return ans;
    }

}
