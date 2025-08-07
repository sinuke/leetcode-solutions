package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>(candyType.length);
        for (int type : candyType) {
            set.add(type);
        }
        return Math.min(set.size(), candyType.length / 2);
    }

}
