package com.sinuke.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> f = new HashMap<>(nums.length);
        for (int num : nums) {
            f.put(num, f.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (f.containsKey(nums[i] + 1)) ans = Math.max(ans, f.get(nums[i]) + f.get(nums[i] + 1));
        }
        return ans;
    }

}