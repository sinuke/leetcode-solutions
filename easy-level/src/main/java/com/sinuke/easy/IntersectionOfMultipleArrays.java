package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfMultipleArrays {

    public List<Integer> intersection(int[][] nums) {
        int[] counts = new int[1001];
        for (int[] num : nums) {
            for (int i : num) counts[i]++;
        }

        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == nums.length) list.add(i);
        }

        return list;
    }

}
