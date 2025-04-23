package com.sinuke.easy;

public class FirstLetterToAppearTwice {

    public char repeatedCharacter(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            int indx = c - 'a';
            if (counts[indx] == 1) return c;
            else counts[indx]++;
        }
        return s.charAt(s.length() - 1);
    }

}
