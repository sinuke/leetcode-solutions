package com.sinuke.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountSpecialQuadruplets {

    public int countQuadruplets(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int cnt = 0;
        for (int a = 0; a < nums.length - 3; a++) {
            for (int b = a + 1; b < nums.length - 2; b++) {
                for (int c = b + 1; c < nums.length - 1; c++) {
                    if (map.containsKey(nums[a] + nums[b] + nums[c])) {
                        for (int d : map.get(nums[a] + nums[b] + nums[c])) {
                            if (d > a && d > b && d > c) cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

}
