package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1m = new HashMap<>(26);
        for (char c : s1.toCharArray()) {
            s1m.put(c, s1m.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> s2m = new HashMap<>(26);
        for (int i = 0; i < s2.length(); i++) {
            if (i < s1.length()) {
                s2m.put(s2.charAt(i), s2m.getOrDefault(s2.charAt(i), 0) + 1);
                if (i == s1.length() - 1 && s1m.equals(s2m)) return true;
            } else {
                char prev = s2.charAt(i - s1.length());
                if (s2m.get(prev) == 1) s2m.remove(prev);
                else s2m.replace(prev, s2m.get(prev) - 1);

                char cur = s2.charAt(i);
                s2m.put(cur, s2m.getOrDefault(cur, 0) + 1);

                if (s1m.equals(s2m)) return true;
            }
        }

        return false;
    }

}
