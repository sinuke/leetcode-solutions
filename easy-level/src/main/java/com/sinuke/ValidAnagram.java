package com.sinuke;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    // it is slow - 25 ms
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            var ss = s.substring(i, i + 1);
            map.put(ss, map.getOrDefault(ss, 0) + 1);
            var st = t.substring(i, i + 1);
            map.put(st, map.getOrDefault(st, 0) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }

        return true;
    }

    // much faster - 3 ms
    public boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) return false;
        }

        return true;
    }

}
