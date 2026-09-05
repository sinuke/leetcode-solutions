package com.sinuke.easy;

import java.util.Arrays;

public class DetectPatternOfLengthMRepeatedKOrMoreTimes {

    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i < m; i++) {
            String pat = Arrays.toString(Arrays.copyOfRange(arr, i, i + m));
            String prev = pat;
            int cnt = 1;
            for (int j = i + m; j < arr.length; j += m) {
                pat = Arrays.toString(Arrays.copyOfRange(arr, j, j + m));

                if (prev.equals(pat)) cnt++;
                else cnt = 1;

                prev = pat;
                if (cnt >= k) return true;
            }
        }

        return false;
    }

}
