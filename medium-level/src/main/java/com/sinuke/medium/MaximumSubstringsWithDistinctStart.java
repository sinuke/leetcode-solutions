package com.sinuke.medium;

public class MaximumSubstringsWithDistinctStart {

    public int maxDistinct(String s) {
        int[] freq = new int[26];
        int cnt = 0;
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            cnt += freq[c - 'a'] == 1 ? 1 : 0;
        }
        return cnt;
    }

}
