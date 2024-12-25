package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) return true;
            map.put(nums[i], i);
        }

        return false;
    }

    public boolean containsNearbyDuplicateSlow(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length && j < i + k + 1) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) return true;
                j++;
            }
        }

        return false;
    }

}
