package com.sinuke.medium;

public class CountDigitAppearances {

    // 3 ms - 100 %
    public int countDigitOccurrences(int[] nums, int digit) {
        int[] d = new int[10];
        for (int num : nums) {
            while (num > 0) {
                d[num % 10]++;
                num /= 10;
            }
        }
        return d[digit];
    }

    // 4 ms - 97.42 %
    public int countDigitOccurrences2(int[] nums, int digit) {
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
