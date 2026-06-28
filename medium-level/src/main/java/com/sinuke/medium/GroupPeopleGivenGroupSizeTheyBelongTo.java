package com.sinuke.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupPeopleGivenGroupSizeTheyBelongTo {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int g = groupSizes[i];
            map.putIfAbsent(g, new ArrayList<>(g));
            map.get(g).add(i);

            if (map.get(g).size() == g) {
                result.add(map.get(g));
                map.remove(g);
            }
        }
        return result;
    }

}
