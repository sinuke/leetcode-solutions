package com.sinuke;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        int maxLength = 1;
        Map<Character, Integer> chars = new HashMap<>(s.length());
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            var c = s.charAt(i);
            if (chars.containsKey(c) && chars.get(c) >= j) j = chars.get(c) + 1;

            maxLength = Math.max(maxLength, i - j + 1);
            chars.put(c, i);
            i++;
        }

        return maxLength;
    }

}
