package com.sinuke.easy;

import java.util.HashMap;

public class FindTheDistinctDifferenceArray {

    public int[] distinctDifferenceArray(int[] nums) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        HashMap<Integer, Integer> suffix = new HashMap<>();

        for (int num: nums) {
            suffix.put(num, suffix.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            prefix.put(x, prefix.getOrDefault(x, 0) + 1);
            suffix.put(x, suffix.get(x) - 1);
            if (suffix.get(x) == 0) {
                suffix.remove(x);
            }

            nums[i] = prefix.size() - suffix.size();
        }

        return nums;
    }

}
