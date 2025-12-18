package com.sinuke.easy;

public class DayOfTheWeek {

    private static final String[] dayTitles = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] days = new int[] {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public String dayOfTheWeek(int day, int month, int year) {
        int dayInYear = days[month - 1] + day + ((month > 2 && isLeap(year)) ? 1 : 0);
        int years = year - 1971 - 1;
        int leapCount = 0;
        for (int y = year - 1; y >= 1971; y--) if (isLeap(y)) leapCount++;
        int diff = (years - leapCount) + 2 * leapCount;
        return dayTitles[((5 + diff) % 7 + dayInYear) % 7];
    }

    private boolean isLeap(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

}
