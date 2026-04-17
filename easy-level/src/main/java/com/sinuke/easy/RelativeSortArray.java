package com.sinuke.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        return Arrays.stream(arr1)
                .boxed()
                .sorted(Comparator.comparingInt(i -> map.getOrDefault(i, i)))
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
