package com.sinuke.easy;

import java.util.Arrays;

public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0, i = 0;
        while (i < nums.length) {
            result += nums[i];
            i += 2;
        }
        return result;
    }

}
