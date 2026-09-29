package com.sinuke.easy;

import java.util.*;

public class RearrangeArrayByRemovingDistinctValues {

    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 1) keys.add(num);
        }

        Collections.sort(keys);

        int i = 0;
        while (!map.isEmpty()) {
            int j = 0;
            while (j < keys.size()) {
                ans[i++] = keys.get(j);
                if (map.get(keys.get(j)) - 1 == 0) {
                    map.remove(keys.get(j));
                    keys.remove(j);
                } else {
                    map.replace(keys.get(j), map.get(keys.get(j)) - 1);
                    j++;
                }
            }
        }

        return ans;
    }

}
