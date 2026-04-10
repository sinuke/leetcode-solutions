package com.sinuke.easy;

public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;

        int[] chars = new int[26];
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) diff++;
            chars[s.charAt(i) - 'a']++;
        }

        if (diff == 0) {
            for (int c : chars) {
                if (c >= 2) return true;
            }
        } else if (diff == 2) {
            for (char c : goal.toCharArray()) {
                chars[c - 'a']--;
            }

            for (int c : chars) {
                if (c != 0) return false;
            }
            return true;
        }

        return false;
    }

}
