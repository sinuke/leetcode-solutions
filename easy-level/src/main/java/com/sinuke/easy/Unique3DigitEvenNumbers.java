package com.sinuke.easy;

public class Unique3DigitEvenNumbers {

    public int totalNumbers(int[] digits) {
        int[] f = new int[10];
        for (int d : digits) f[d]++;
        int cnt = 0;
        for (int i = 100; i < 999; i += 2) {
            if (check(i, f)) cnt++;
        }
        return cnt;
    }

    private boolean check(int n, int[] f) {
        int[] d = new int[10];
        while (n > 0) {
            d[n % 10]++;
            n /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (d[i] > f[i]) return false;
        }

        return true;
    }

}
