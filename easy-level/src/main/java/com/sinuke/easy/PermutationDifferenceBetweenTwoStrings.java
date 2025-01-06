package com.sinuke.easy;

public class PermutationDifferenceBetweenTwoStrings {

    public int findPermutationDifference(String s, String t) {
        var map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }

        int result = 0;
        for (int i = 0; i < t.length(); i++) {
            result += Math.abs(map[t.charAt(i) - 'a'] - i);
        }

        return result;
    }

}
