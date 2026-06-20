package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>(pieces.length);
        for (int[] p : pieces) map.put(p[0], p);

        int i = 0;
        while (i < arr.length) {
            if (map.containsKey(arr[i])) {
                int[] p = map.get(arr[i]);
                for (int k : p) {
                    if (i >= arr.length || k != arr[i++]) return false;
                }
            } else return false;
        }
        return true;
    }

}
