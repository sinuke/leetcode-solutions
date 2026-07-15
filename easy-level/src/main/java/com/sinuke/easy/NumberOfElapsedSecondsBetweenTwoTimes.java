package com.sinuke.easy;

public class NumberOfElapsedSecondsBetweenTwoTimes {

    public int secondsBetweenTimes(String startTime, String endTime) {
        return toSeconds(endTime) - toSeconds(startTime);
    }

    private int toSeconds(String time) {
        int h = 10 * (time.charAt(0) - '0') + (time.charAt(1) - '0');
        int m = 10 * (time.charAt(3) - '0') + (time.charAt(4) - '0');
        int s = 10 * (time.charAt(6) - '0') + (time.charAt(7) - '0');

        return h * 3600 + m * 60 + s;
    }

}
