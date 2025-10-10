package com.sinuke.easy;

public class DayOfTheYear {

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        boolean isLeap = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        int[] days = new int[] {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        return days[month - 1] + day + ((month > 2 && isLeap) ? 1 : 0);
    }

}
