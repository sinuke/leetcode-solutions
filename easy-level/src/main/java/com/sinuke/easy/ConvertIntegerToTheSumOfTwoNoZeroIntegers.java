package com.sinuke.easy;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    public int[] getNoZeroIntegers(int n) {
        int a = 1, b = n - a;
        for (int i = 1; i < n; i++) {
            a = i;
            b = n - i;
            if (isNoZero(a) && isNoZero(b)) break;
        }
        return new int[] {a, b};
    }

    private boolean isNoZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) return false;
            n /= 10;
        }
        return true;
    }

}
