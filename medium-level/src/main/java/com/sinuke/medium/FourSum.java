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
                int sum2 = sum + nums[j];

                for (int k = i + 1; k < j - 1; k++) {
                    int sum3 = sum2 + nums[k];

                    for (int t = j - 1; t > k; t--) {
                        if (sum3 + nums[t] == target) {
                            result.add(List.of(nums[i], nums[j], nums[k], nums[t]));
                        }
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

}
