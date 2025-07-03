package com.sinuke.easy;

public class FindNUniqueIntegersSumUpToZero {

    public int[] sumZero(int n) {
        int[] result = new int[n];
        int i = 0;
        while (i < n / 2) {
            result[i] = i + 1;
            result[n - i - 1] = - i - 1;
            i++;
        }

        return result;
    }

}
