package com.sinuke.easy;

public class DecryptStringFromAlphabetToIntegerMapping {

    public String freqAlphabets(String s) {
        int i = s.length() - 1;
        var sb = new StringBuilder();
        while (i >= 0) {
            int val = 0;
            if (s.charAt(i) == '#') {
                val = ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0'));
                i -= 2;
            } else val = s.charAt(i) - '0';

            sb.append((char)('a' + val - 1));
            i--;
        }

        return sb.reverse().toString();
    }

}
