package com.sinuke.easy;

public class MinimumRotationsToDialNumberI {

    public int minRotations(String s) {
        int cnt = 0, prev = 0;
        for (char c : s.toCharArray()) {
            int d = c - '0';
            cnt += Math.min(Math.abs(prev - d), 10 - Math.abs(prev - d));
            prev = d;
        }
        return cnt;
    }

}
