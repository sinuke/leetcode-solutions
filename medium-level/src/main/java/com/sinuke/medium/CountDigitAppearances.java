package com.sinuke.medium;

public class CountDigitAppearances {

    public int countDigitOccurrences(int[] nums, int digit) {
        int cnt = 0;
        for (int num : nums) {
            while (num > 0) {
                if (num % 10 == digit) cnt++;
                num /= 10;
            }
        }
        return cnt;
    }

}
