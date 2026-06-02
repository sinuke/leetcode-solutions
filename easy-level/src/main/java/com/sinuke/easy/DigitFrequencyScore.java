package com.sinuke.easy;

public class DigitFrequencyScore {

    // 1 ms
    public int digitFrequencyScore(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }

    // 1 ms
    public int digitFrequencyScore2(int n) {
        int[] digits = new int[10];
        while (n > 0) {
            digits[n % 10]++;
            n /= 10;
        }

        int result = 0;
        for (int i = 0; i < 10; i++) result += i * digits[i];
        return result;
    }

}
