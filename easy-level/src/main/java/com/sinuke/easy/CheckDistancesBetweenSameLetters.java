package com.sinuke.easy;

public class CheckDistancesBetweenSameLetters {

    public boolean checkDistances(String s, int[] distance) {
        int[] dp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            if (dp[num] == 0) dp[num] = i == 0 ? -1 : i;
            else {
                dp[num] = i - (dp[num] == -1 ? 0 : dp[num]) - 1;
                if (dp[num] != distance[num]) return false;
            }
        }
        return true;
    }

}
