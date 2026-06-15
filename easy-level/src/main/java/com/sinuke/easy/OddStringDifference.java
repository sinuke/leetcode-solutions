package com.sinuke.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OddStringDifference {

    public String oddString(String[] words) {
        List<Map<Integer, int[]>> lst = new ArrayList<>(words[0].length());
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length() - 1; j++) {
                int diff = words[i].charAt(j + 1) - words[i].charAt(j);
                if (lst.size() < j + 1) lst.add(new HashMap<>());
                lst.get(j).putIfAbsent(diff, new int[2]);
                lst.get(j).get(diff)[0]++;
                lst.get(j).get(diff)[1] = i;
            }
        }

        for (var map : lst) {
            for (var v : map.values()) {
                if (v[0] == 1) return words[v[1]];
            }
        }
        return words[0];
    }

}
