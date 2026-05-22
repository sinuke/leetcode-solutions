package com.sinuke.medium;

public class SeparateBlackAndWhiteBalls {

    public long minimumSteps(String s) {
        long result = 0L, cnt = 0L;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') cnt++;
            else result += cnt;
        }
        return result;
    }

}
