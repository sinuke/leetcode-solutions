package com.sinuke.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generate(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void generate(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) result.add(new ArrayList<>(current));
        else for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;

            current.add(nums[i]);
            used[i] = true;
            generate(nums, used, current, result);
            used[i] = false;
            current.removeLast();
        }
    }

}
