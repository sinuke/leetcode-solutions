package com.sinuke.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistanceBetweenThreeEqualElementsII {

    // 111 ms
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            List<Integer> list = map.get(nums[i]);
            list.add(i);
            if (list.size() >= 3) {
                int x = getX(list.get(list.size() - 3), list.get(list.size() - 2), list.get(list.size() - 1));
                result = Math.min(result, x);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // 138 ms
    public int minimumDistance2(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int result = Integer.MAX_VALUE;
        for (var entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() >= 3) {
                for (int i = 0; i < list.size() - 2; i++) {
                    result = Math.min(result, getX(list.get(i), list.get(i + 1), list.get(i + 2)));
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int getX(int i, int j, int k) {
        return Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
    }

}
