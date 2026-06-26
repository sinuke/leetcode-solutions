package com.sinuke.easy;

public class LatestTimeByReplacingHiddenDigits {

    public String maximumTime(String time) {
        char[] t = new char[5];
        // hour
        if (time.charAt(0) == '?') {
            if (time.charAt(1) != '?' && time.charAt(1) - '0' > 3) t[0] = '1';
            else if ((time.charAt(1) != '?' && time.charAt(1) - '0' < 4) || (time.charAt(1) == '?')) t[0] = '2';
        } else t[0] = time.charAt(0);
        if (time.charAt(1) == '?') t[1] = t[0] == '0' || t[0] == '1' ? '9' : '3';
        else t[1] = time.charAt(1);
        t[2] = ':';

        // minute
        t[3] = time.charAt(3) == '?' ? '5' : time.charAt(3);
        t[4] = time.charAt(4) == '?' ? '9' : time.charAt(4);

        return new String(t);
    }
}
