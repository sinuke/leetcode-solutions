package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i + 1;
        List<List<Integer>> result = new ArrayList<>();
        generate(nums, k, 0, new ArrayList<>(), result);
        return result;
    }

    private void generate(int[] nums, int length, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            generate(nums, length, i + 1, current, result);
            current.removeLast();
        }
    }

}
