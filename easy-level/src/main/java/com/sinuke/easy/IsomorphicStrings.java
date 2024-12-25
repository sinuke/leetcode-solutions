package com.sinuke.easy;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        int[] sChars = new int[96];
        int[] tChars = new int[96];
        int sChar;
        int tChar;

        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i) - 32;
            tChar = t.charAt(i) - 32;

            if (sChars[sChar] != tChars[tChar]) return false;

            sChars[sChar] = i + 1;
            tChars[tChar] = i + 1;
        }

        return true;
    }
    
}
