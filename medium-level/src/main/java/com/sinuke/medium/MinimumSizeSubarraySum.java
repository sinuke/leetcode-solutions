package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] == target) return 1;
            else if (sum == target || map.containsKey(target - nums[i])) min = Math.min(min, i - map.get(target - nums[i]));

            map.put(sum, i);
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
