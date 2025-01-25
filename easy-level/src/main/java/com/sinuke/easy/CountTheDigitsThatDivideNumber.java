package com.sinuke.easy;

public class CountTheDigitsThatDivideNumber {

    public int countDigits(int num) {
        int tmp = num, count = 0;

        while (tmp > 0) {
            int digit = tmp % 10;
            if (num % digit == 0) count++;
            tmp = tmp / 10;
        }

        return count;
    }

}
