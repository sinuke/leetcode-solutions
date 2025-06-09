package com.sinuke.easy;

public class MinimizeStringLength {

    public int minimizedStringLength(String s) {
        char[] chars = new char[26];
        int count = 0;
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
            count += chars[c - 'a'] == 1 ? 1 : 0;
        }
        return count;
    }

}
