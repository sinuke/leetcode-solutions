package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

class SmallestMissingIntegerGreaterThanOrEqualSequentialPrefixSum {

    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int start = 0, end = 0, l = 1, csum = nums[0], sum = nums[0];
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1 && start == 0) {
                end = i;
                csum += nums[i];
            } else {
                if (end + 1 > l && start == 0) {
                    sum = csum;
                    l = end + 1;
                }

                start = i;
                csum = 0;
                end = i;
            }
            set.add(nums[i]);
        }

        if (end + 1 > l && start == 0) {
            sum = csum;
            l = end + 1;
        }

        while (set.contains(sum)) sum++;
        return sum;
    }

}
