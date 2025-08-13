package com.sinuke.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {

    // 1579 ms
    public List<Integer> findAnagrams(String s, String p) {
        char[] pchars = p.toCharArray();
        Arrays.sort(pchars);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length() - pchars.length + 1; i++) {
            var substr = s.substring(i, i + pchars.length).toCharArray();
            Arrays.sort(substr);
            if (isAnagram(substr, pchars)) result.add(i);
        }

        return result;
    }

    // 33 ms
    public List<Integer> findAnagrams2(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int start = 0, matched = 0;
        List<Integer> result = new ArrayList<>();
        for (int end = 0; end < s.length(); end++) {
            var ch = s.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) matched++;
            }

            if (end >= p.length() - 1) {
                if (matched == map.size()) {
                    result.add(start);
                }

                ch = s.charAt(start);
                start++;
                if (map.containsKey(ch)) {
                    int value  = map.get(ch);
                    if (value == 0) matched--;
                    map.put(ch, map.get(ch) + 1);
                }
            }
        }

        return result;
    }

    private boolean isAnagram(char[] s, char[] p) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] != s[i]) return false;
        }
        return true;
    }

}
