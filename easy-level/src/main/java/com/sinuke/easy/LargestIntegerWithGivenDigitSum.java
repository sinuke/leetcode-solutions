package com.sinuke.easy;

public class LargestIntegerWithGivenDigitSum {

    public int largestInteger(int n, int s) {
        if (9 * n < s) return -1;

        int a = 0;
        while (n > 0) {
            if (s > 9) {
                a = a * 10 + 9;
                s -= 9;
            } else {
                a = a * 10 + s;
                s = 0;
            }
            n--;
        }
        return a;
    }

}
