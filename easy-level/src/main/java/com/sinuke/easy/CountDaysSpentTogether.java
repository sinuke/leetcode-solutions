package com.sinuke.easy;

public class CountDaysSpentTogether {

    private static final int[] days = new int[] {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] a = new int[] {day(arriveAlice), day(leaveAlice)};
        int[] b = new int[] {day(arriveBob), day(leaveBob)};

        if (a[0] <= b[0] && a[1] >= b[0]) {
            if (b[1] <= a[1]) return b[1] - b[0] + 1;
            else return a[1] - b[0] + 1;
        }
        else if (b[0] <= a[0] && b[1] >= a[0]) {
            if (a[1] <= b[1]) return a[1] - a[0] + 1;
            else return b[1] - a[0] + 1;
        }
        return 0;
    }

    private int day(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));
        return days[month - 1] + day;
    }

}
