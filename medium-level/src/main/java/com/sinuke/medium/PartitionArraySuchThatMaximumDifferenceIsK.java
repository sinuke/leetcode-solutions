package com.sinuke.medium;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 1, i = 0, start = 0;
        while (i < nums.length) {
            if (nums[i] - nums[start] > k) {
                start = i;
                count++;
            }
            i++;
        }

        return count;
    }

}
