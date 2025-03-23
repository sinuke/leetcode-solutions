package com.sinuke.easy;

import java.util.Arrays;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] expected = new int[n];
        System.arraycopy(heights, 0, expected, 0, n);
        Arrays.sort(expected);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != expected[i]) count++;
        }

        return count;
    }

}
