package com.sinuke.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConvertArrayInto2DArrayWithConditions {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<Set<Integer>> ls = new ArrayList<>();
        List<List<Integer>> ll = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int num : nums) {
            map.putIfAbsent(num, -1);
            int i = map.get(num);
            if (i == ls.size() - 1) {
                ls.add(new HashSet<>());
                ll.add(new ArrayList<>());
            }
            i++;

            ls.get(i).add(num);
            ll.get(i).add(num);
            map.replace(num, i);
        }

        return ll;
    }

}
