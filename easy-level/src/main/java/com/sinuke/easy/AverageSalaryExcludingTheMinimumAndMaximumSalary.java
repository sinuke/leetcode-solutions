package com.sinuke.easy;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;

        for (int s : salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }

        return ((double)(sum - min - max)) / (salary.length - 2);
    }

}
