package com.sinuke.easy;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] dp = new int[52];
        for (char c : s.toCharArray()) {
            dp[c >= 'a' ? c - 'a' : c - 'A' + 26]++;
        }

        int size = 0;
        boolean isSingleLetterUsed = false;

        for (int j : dp) {
            if (j % 2 == 0) size += j;
            else {
                size += j - 1;
                if (!isSingleLetterUsed) {
                    size++;
                    isSingleLetterUsed = true;
                }
            }
        }

        return size;
    }

}
