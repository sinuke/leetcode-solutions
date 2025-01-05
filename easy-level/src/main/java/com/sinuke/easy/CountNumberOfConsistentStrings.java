package com.sinuke.easy;

public class CountNumberOfConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        char[] chars = new char[26];

        for (char c : allowed.toCharArray()) {
            chars[c - 'a']++;
        }

        int result = 0;
        for (var word : words) {
            result++;

            for (char c : word.toCharArray()) {
                if (chars[c - 'a'] == 0) {
                    result--;
                    break;
                }
            }
        }

        return result;
    }

}
