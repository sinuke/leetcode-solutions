package com.sinuke.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    public int minimumOperations(int[] nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>(100);
        int[] freq = new int[101];

        for (int num : nums) {
            freq[num]++;
            map.putIfAbsent(freq[num], new HashSet<>());
            map.get(freq[num]).add(num);
        }

        int i = 0, cnt = 0;
        while (map.size() != 1 && i < nums.length) {
            doAction(nums[i++], freq, map);
            if (i < nums.length) doAction(nums[i++], freq, map);
            if (i < nums.length) doAction(nums[i++], freq, map);
            cnt++;
        }

        return cnt;
    }

    private void doAction(int num, int[] freq, Map<Integer, Set<Integer>> map) {
        int oldFreq = freq[num];

        map.get(oldFreq).remove(num);
        if (map.get(oldFreq).isEmpty()) map.remove(oldFreq);

        if (oldFreq == 1) freq[num] = 0;
        else {
            freq[num]--;
            map.putIfAbsent(oldFreq - 1, new HashSet<>());
            map.get(oldFreq - 1).add(num);
        }
    }

}
