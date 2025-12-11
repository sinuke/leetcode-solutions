package com.sinuke.easy;

public class NumberOfDaysBetweenTwoDates {

    private static final int[] days = new int[] {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(f(date1) - f(date2));
    }

    private int f(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        int result = 0;
        for (int y = 1970; y < year; y++) result += isLeap(y) ? 366 : 365;

        return result + days[month - 1] + day + ((month > 2 && isLeap(year)) ? 1 : 0);
    }

    private boolean isLeap(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

}
