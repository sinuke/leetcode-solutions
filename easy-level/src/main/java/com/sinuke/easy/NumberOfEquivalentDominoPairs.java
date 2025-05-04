package com.sinuke.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfEquivalentDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        Map<Set<Integer>, Integer> map = new HashMap<>();

        for (int[] domino : dominoes) {
            Set<Integer> set = new HashSet<>();
            set.add(domino[0]);
            set.add(domino[1]);
            count += map.getOrDefault(set, 0);
            map.put(set, map.getOrDefault(set, 0) + 1);
        }

        return count;
    }

}
