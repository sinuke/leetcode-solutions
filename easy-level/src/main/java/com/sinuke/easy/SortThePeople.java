package com.sinuke.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortThePeople {

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>(names.length);
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .map(Map.Entry::getValue)
                .toArray(String[]::new);
    }

}
