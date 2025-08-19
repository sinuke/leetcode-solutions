package com.sinuke.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {
            int sum = nums[i];

            for (int j = nums.length - 1; j > i + 2; j--) {
                long sum2 = sum + nums[j];

                Set<Long> set = new HashSet<>();
                for (int k = i + 1; k < j; k++) {
                    if (set.contains(target - sum2 - nums[k])) result.add(List.of(nums[i], nums[j], target - (int) sum2 - nums[k], nums[k]));
                    else set.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(result);
    }

}
