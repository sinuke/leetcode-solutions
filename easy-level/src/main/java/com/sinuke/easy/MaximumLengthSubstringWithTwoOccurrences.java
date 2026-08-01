package com.sinuke.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumLengthSubstringWithTwoOccurrences {

    public int maximumLengthSubstring(String s) {
        Map<Character, Queue<Integer>> map = new HashMap<>(26);
        int l = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.putIfAbsent(c, new LinkedList<>());
            Queue<Integer> q = map.get(c);
            q.add(i);
            if (q.size() == 3) start = Math.max(start, q.poll() + 1);

            l = Math.max(l, i - start + 1);
        }
        return l;
    }

}
