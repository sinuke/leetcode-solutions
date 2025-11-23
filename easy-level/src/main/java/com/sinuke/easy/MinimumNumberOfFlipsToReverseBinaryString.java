package com.sinuke.easy;

public class MinimumNumberOfFlipsToReverseBinaryString {

    public int minimumFlips(int n) {
        String s = Integer.toBinaryString(n);
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) cnt++;
        }
        return cnt;
    }

}
