package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        int[][] dp = new int[26][words.length];

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                dp[c - 'a'][i]++;
            }
        }

        List<String> result = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < words.length; j++) {
                min = Math.min(min, dp[i][j]);
                if (min == 0) break;
            }
            while (min > 0) {
                result.add(Character.toString(i + 'a'));
                min--;
            }
        }
        return result;
    }

}
