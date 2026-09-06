package com.sinuke.easy;

class Solution {

    public int maxRepeating(String sequence, String word) {
        int l = word.length(), i = l, max = 0;
        if (sequence.length() == l) return sequence.equals(word) ? 1 : 0;
        int[] dp = new int[sequence.length() + 1];

        while (i <= sequence.length()) {
            if (sequence.substring(i - l, i).equals(word)) {
                dp[i] = dp[i - l] + 1;
                max = Math.max(max, dp[i]);
            }
            i += 1;
        }

        return max;
    }

}
