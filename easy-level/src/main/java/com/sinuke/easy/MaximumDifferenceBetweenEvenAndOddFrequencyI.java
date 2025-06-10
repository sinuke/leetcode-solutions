package com.sinuke.easy;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {

    public int maxDifference(String s) {
        int[] dp = new int[26];
        for (char c : s.toCharArray()) {
            dp[c - 'a']++;
        }

        int maxOdd = 0, minEven = Integer.MAX_VALUE;
        for (int val : dp) {
            if (val == 0) continue;
            if (val % 2 == 0 && minEven > val) minEven = val;
            else if (val % 2 != 0 && maxOdd < val) maxOdd = val;
        }

        return maxOdd - minEven;
    }

}
