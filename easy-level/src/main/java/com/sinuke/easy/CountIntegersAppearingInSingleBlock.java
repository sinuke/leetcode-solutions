package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class CountIntegersAppearingInSingleBlock {

    public int countSpecialIntegers(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new int[] {0, Integer.MAX_VALUE, -1});
            map.get(nums[i])[0]++;
            map.get(nums[i])[1] = Math.min(map.get(nums[i])[1], i);
            map.get(nums[i])[2] = Math.max(map.get(nums[i])[2], i);
        }

        int cnt = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue()[0] == entry.getValue()[2] - entry.getValue()[1] + 1) cnt++;
        }
        return cnt;
    }

}