package com.sinuke.easy;

public class IncreasingDecreasingString {

    public String sortString(String s) {
        int[] f = new int[26];
        int chars = 0;
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
            chars++;
        }

        var sb = new StringBuilder();
        while (chars > 0) {
            for (int i = 0; i < 26; i++) {
                if (f[i] != 0) {
                    sb.append((char) (i + 'a'));
                    f[i]--;
                    chars--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (f[i] != 0) {
                    sb.append((char) (i + 'a'));
                    f[i]--;
                    chars--;
                }
            }
        }
        return sb.toString();
    }

}
