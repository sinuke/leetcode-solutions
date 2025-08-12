package com.sinuke.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {

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

    public List<Integer> findAnagrams2(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            Map<Character, Integer> sMap = new HashMap<>();
            for (int j = i; j < i + p.length(); j++) {
                sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
            }

            if (pMap.equals(sMap)) result.add(i);
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
