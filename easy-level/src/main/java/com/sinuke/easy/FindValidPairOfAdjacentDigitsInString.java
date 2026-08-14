package com.sinuke.easy;

public class FindValidPairOfAdjacentDigitsInString {

    public String findValidPair(String s) {
        int[] freq = new int[10];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            freq[c - '0']++;
        }

        for (int i = 0; i < chars.length - 1; i++) {
            char c1 = chars[i];
            char c2 = chars[i + 1];
            int d1 = c1 - '0';
            int d2 = c2 - '0';
            if (c1 != c2 && freq[d1] == d1 && freq[d2] == d2) {
                return "" + c1 + c2;
            }
        }

        return "";
    }

}