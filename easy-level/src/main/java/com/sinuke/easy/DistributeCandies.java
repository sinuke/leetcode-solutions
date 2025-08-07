package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    // 20 ms
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>(candyType.length);
        for (int type : candyType) {
            set.add(type);
        }
        return Math.min(set.size(), candyType.length / 2);
    }

    // 7 ms
    public int distributeCandies2(int[] candyType) {
        int count = 0;
        int[] candy = new int[200_001];
        for (int type : candyType) {
            int index = type + 100_000;
            if (candy[index] == 0) {
                candy[index] = 1;
                count++;
            }
        }
        return Math.min(count, candyType.length / 2);
    }

}
