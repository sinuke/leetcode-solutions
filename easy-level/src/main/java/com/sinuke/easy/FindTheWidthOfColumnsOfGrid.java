package com.sinuke.easy;

public class FindTheWidthOfColumnsOfGrid {

    public int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;
        int[] result = new int[n];
        for (int col = 0; col < n; col++) {
            for (int[] ints : grid) {
                result[col] = Math.max(result[col], len(ints[col]));
            }
        }
        return result;
    }

    private int len(int x) {
        int length = x <= 0 ? 1 : 0;
        x = Math.abs(x);
        while (x > 0) {
            length++;
            x /= 10;
        }
        return length;
    }

}
