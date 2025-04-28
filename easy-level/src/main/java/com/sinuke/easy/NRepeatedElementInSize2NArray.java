package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementInSize2NArray {

    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) return num;
            else map.put(num, 1);
        }
        return 0;
    }

}
