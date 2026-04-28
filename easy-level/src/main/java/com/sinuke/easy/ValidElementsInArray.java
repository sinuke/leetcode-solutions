package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class ValidElementsInArray {

    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(nums[i], left[i - 1]);
            right[n - i - 1] = Math.max(nums[n - i - 1], right[n - i]);
        }

        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1 || nums[i] > left[i - 1] || nums[i] > right[i + 1]) result.add(nums[i]);
        }
        return result;
    }

}
