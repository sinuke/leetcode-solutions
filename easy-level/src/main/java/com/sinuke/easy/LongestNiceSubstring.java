package com.sinuke.easy;

public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        String ans = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (str.length() > ans.length() && isNice(str)) ans = str;
            }
        }
        return ans;
    }

    private boolean isNice(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            boolean isUpper = Character.isUpperCase(c);
            int indx = isUpper ? c - 'A' : c - 'a';

            if (freq[indx] == 0) freq[indx] += isUpper ? 2 : 1;
            else if (freq[indx] == 1) freq[indx] += isUpper ? 2 : 0;
            else if (freq[indx] == 2) freq[indx] += isUpper ? 0 : 1;
        }

        for (int f : freq) {
            if (f > 0 && f != 3) return false;
        }

        return true;
    }

}
