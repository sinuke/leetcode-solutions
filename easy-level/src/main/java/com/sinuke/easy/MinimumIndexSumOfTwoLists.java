package com.sinuke.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length) {
            var lst = list2;
            list2 = list1;
            list1 = lst;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list2.length; i++) map.put(list2[i], i);

        int min = Integer.MAX_VALUE;
        Map<Integer, List<String>> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            if (map.containsKey(list1[i])) {
                min = Math.min(min, i + map.get(list1[i]));
                if (i + map.get(list1[i]) == min) {
                    map2.putIfAbsent(min, new ArrayList<>());
                    map2.get(min).add(list1[i]);
                }
            }
        }

        return map2.get(min).toArray(new String[0]);
    }

}
