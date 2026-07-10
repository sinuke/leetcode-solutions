package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class MakeTwoArraysEqualByReversingSubarrays {

    public boolean canBeEqual(int[] target, int[] arr) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) cnt++;
            map.put(target[i], map.getOrDefault(target[i], 0) + 1);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        return cnt == 0 || map.entrySet().stream().noneMatch(e -> e.getValue() % 2 != 0);
    }

}
