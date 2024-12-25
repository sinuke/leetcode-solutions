package com.sinuke.easy;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i != nums[i]) return i;
        }

        return n;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }

}
