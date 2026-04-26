package com.sinuke.easy;

public class MinimumMovesToConvertString {

    public int minimumMoves(String s) {
        int i = 0, cnt = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                i += 2;
                cnt++;
            }
            i++;
        }
        return cnt;
    }

}
