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
        List<Integer> result = new ArrayList<>();
        while (i < s.length()) {
            int pos = map.get(s.charAt(i));

            int j = i + 1;
            while (j < pos) {
                if (map.get(s.charAt(j)) > pos) pos = map.get(s.charAt(j));
                j++;
            }

            int len = pos - i + 1;
            result.add(len);
            i = pos + 1;
        }

        return result;
    }

}
