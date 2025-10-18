package com.sinuke.medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(nums, new LinkedHashSet<>(), result);
        return result;
    }

    private void generate(int[] nums, LinkedHashSet<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) result.add(new ArrayList<>(current));
        else for (int num : nums) {
            if (current.contains(num)) continue;

            current.add(num);
            generate(nums, current, result);
            current.removeLast();
        }
    }

}
