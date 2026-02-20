package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class FindSubarraysWithEqualSum {

    public boolean findSubarrays(int[] nums) {
        Set<Integer> sums = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i - 1] + nums[i];
            if (sums.contains(sum)) return true;
            else sums.add(sum);
        }
        return false;
    }

}
