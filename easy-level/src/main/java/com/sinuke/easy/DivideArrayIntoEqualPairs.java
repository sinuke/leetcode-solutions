package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualPairs {

    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (var value : map.values()) {
            if (value % 2 != 0) return false;
        }

        return true;
    }

}
