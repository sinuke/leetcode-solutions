package com.sinuke.easy;

public class CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        int weeks = n / 7, remainingDays = n % 7, total = 0;
        for (int week = 0; week < weeks; week++) {
            total += (week + 4) * 7;
        }

        for (int day = 1; day <= remainingDays; day++) {
            total += day + weeks;
        }

        return total;
    }

}
