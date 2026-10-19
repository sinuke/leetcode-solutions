package com.sinuke.easy;

public class LexicographicallySmallestStringAfterSwap {

    public String getSmallestString(String s) {
        char[] ch = s.toCharArray();
        for (int i = 1; i < ch.length; i++) {
            int p = ch[i - 1] - '0';
            int c = ch[i] - '0';

            if (p % 2 == c % 2 && c < p) {
                ch[i - 1] = ch[i];
                ch[i] = (char) (p + '0');
                break;
            }
        }

        return new String(ch);
    }

}
