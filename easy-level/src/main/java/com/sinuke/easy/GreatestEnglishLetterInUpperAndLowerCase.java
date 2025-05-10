package com.sinuke.easy;

public class GreatestEnglishLetterInUpperAndLowerCase {

    public String greatestLetter(String s) {
        int[] dp = new int[26];
        char max = 0;

        for (char c : s.toCharArray()) {
            int index = c - 'a' >= 0 ? c - 'a' : c - 'A';
            int code = c - 'a' >= 0 ? 1 : 2;
            if (dp[index] == 0 || (dp[index] < 3 && dp[index] != code)) dp[index] += code;
            if (dp[index] == 3 && Character.toUpperCase(c) > max) max = Character.toUpperCase(c);
        }

        return max == 0 ? "" : "" + max;
    }

}
