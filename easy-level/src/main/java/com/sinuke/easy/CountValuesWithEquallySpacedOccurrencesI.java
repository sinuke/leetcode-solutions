package com.sinuke.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountValuesWithEquallySpacedOccurrencesI {

    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for (var entry : map.entrySet()) {
            var lst = entry.getValue();
            if (lst.size() == 3 && lst.get(1) - lst.get(0) == lst.get(2) - lst.get(1)) cnt++;
        }
        return cnt;
    }

}
