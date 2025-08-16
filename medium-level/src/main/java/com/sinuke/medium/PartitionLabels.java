package com.sinuke.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int i = 0;
        List<Integer> result = new ArrayList<>(s.length() / 2);
        while (i < s.length()) {
            int pos = map.get(s.charAt(i));

            int j = i + 1;
            while (j < pos) {
                pos = Math.max(pos, map.get(s.charAt(j)));
                j++;
            }
            result.add(pos - i + 1);
            i = pos + 1;
        }

        return result;
    }

}
