package com.sinuke.easy;

public class CountIntegersWithEvenDigitSum {

    public int countEven(int num) {
        int count = 0;
        while (num > 0) {
            if (sum(num) % 2 == 0) count++;
            num--;
        }
        return count;
    }

    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}
