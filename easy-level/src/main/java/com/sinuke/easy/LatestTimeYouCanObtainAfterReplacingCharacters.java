package com.sinuke.easy;

public class LatestTimeYouCanObtainAfterReplacingCharacters {

    public String findLatestTime(String s) {
        char[] t = new char[5];
        // hour
        if (s.charAt(0) == '?') {
            if (s.charAt(1) != '?' && s.charAt(1) - '0' > 1) t[0] = '0';
            else if ((s.charAt(1) != '?' && s.charAt(1) - '0' < 2) || (s.charAt(1) == '?')) t[0] = '1';
        } else t[0] = s.charAt(0);
        if (s.charAt(1) == '?') t[1] = t[0] == '0' ? '9' : '1';
        else t[1] = s.charAt(1);
        t[2] = ':';

        // minute
        t[3] = s.charAt(3) == '?' ? '5' : s.charAt(3);
        t[4] = s.charAt(4) == '?' ? '9' : s.charAt(4);

        return new String(t);
    }
}
