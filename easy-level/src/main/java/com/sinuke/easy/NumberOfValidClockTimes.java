package com.sinuke.easy;

public class NumberOfValidClockTimes {

    public int countTime(String time) {
        char h1 = time.charAt(0);
        char h2 = time.charAt(1);
        int rh = 1;

        if (h1 == '?' && h2 == '?') rh = 24;
        else if (h1 == '?') rh = h2 - '0' < 4 ? 3 : 2;
        else if (h2 == '?') rh = h1 - '0' < 2 ? 10 : 4;

        return rh * (time.charAt(4) == '?' ? 10 : 1) * (time.charAt(3) == '?' ? 6 : 1);
    }

}
