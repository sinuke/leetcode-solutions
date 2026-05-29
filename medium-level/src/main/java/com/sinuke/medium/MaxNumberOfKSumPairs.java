package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        int cnt = 0;
        for (var e : map.entrySet()) {
            if (e.getValue() > 0 && e.getKey() * 2 == k) {
                cnt += e.getValue() / 2;
                map.replace(e.getValue(), -1);
            } else if (e.getValue() > 0 && map.containsKey(k - e.getKey()) && map.get(k - e.getKey()) > 0) {
                cnt += Math.min(e.getValue(), map.get(k - e.getKey()));
                map.replace(e.getKey(), -1);
                map.replace(k - e.getKey(), -1);
            }
        }

        return cnt;
    }

}
