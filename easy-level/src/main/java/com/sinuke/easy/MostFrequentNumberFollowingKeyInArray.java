package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentNumberFollowingKeyInArray {

    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == key) {
                while (nums[i] == key && i < nums.length - 1) {
                    i++;
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                    if (max == 0 || map.get(nums[i]) > map.get(max)) max = nums[i];
                }
            }
            i++;
        }
        return max;
    }

}
