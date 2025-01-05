package com.sinuke.easy;

public class DivisibleAndNonDivisibleSumsDifference {

    public int differenceOfSums(int n, int m) {
        int num1 = 0, num2 = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) num2 += i;
            else num1 += i;
        }

        return num1 - num2;
    }

    // from LeetCode
    public int differenceOfSums2(int n, int m) {
        int totalSum = (n * (n + 1)) / 2;
        int k = n / m;
        int num2 = m * k * (k + 1) / 2;
        int num1 = totalSum - num2;
        return num1 - num2;
    }

}
