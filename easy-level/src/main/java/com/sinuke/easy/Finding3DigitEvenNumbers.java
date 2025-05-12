package com.sinuke.easy;

import java.util.Arrays;

public class Finding3DigitEvenNumbers {

    public int[] findEvenNumbers(int[] digits) {
        int[] results = new int[1000];
        int count = 0;
        int[] freq = new int[10];
        for (int digit : digits) freq[digit]++;

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < 9; k += 2) {
                    if ((freq[i] > 0 && freq[j] > (i == j ? 1 : 0)) && (freq[k] > (k == i ? 1 : 0) + (k == j ? 1 : 0))) {
                        results[count++] = i * 100 + j * 10 + k;
                    }
                }
            }
        }

        int[] result = Arrays.copyOf(results, count);
        Arrays.sort(result);
        return result;
    }

}
