package com.sinuke.easy;

public class CountTheNumberOfSpecialCharactersI {

    public int numberOfSpecialChars(String word) {
        int[] dp = new int[52];
        int count = 0;
        for (char c : word.toCharArray()) {
            int i = c >= 'a' ? c - 'a' : c - 'A' + 26;
            int j = i >= 26 ? i - 26 : i + 26;
            if (dp[i] != -1) dp[i]++;
            if (dp[j] > 0) {
                count++;
                dp[j] = -1;
                dp[i] = -1;
            }
        }
        return count;
    }

}
