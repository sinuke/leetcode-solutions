package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        int[] dp = new int[26];
        dp[s.charAt(0) - 'a'] = 10;
        for (int i = 1; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (dp[index] >= 10) max = Math.max(i + 10 - dp[index] - 1, max);
            else dp[index] = i + 10;
        }
        return max;
    }

    public int maxLengthBetweenEqualCharacters2(String s) {
        int max = -1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) max = Math.max(i - map.get(s.charAt(i)) - 1, max);
            else map.put(s.charAt(i), i);
        }
        return max;
    }

}
