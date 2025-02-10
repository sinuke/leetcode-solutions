package com.sinuke.easy;

import java.util.Arrays;

public class LargestLocalValuesInMatrix {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                result[i - 1][j - 1] = getMax2(grid, i, j);
            }
        }

        return result;
    }

    private int getMax(int[][] grid, int i, int j) {
        var tmp = new int[]{
                grid[i][j],
                grid[i - 1][j],
                grid[i + 1][j],
                grid[i][j - 1],
                grid[i][j + 1],
                grid[i - 1][j - 1],
                grid[i + 1][j - 1],
                grid[i - 1][j + 1],
                grid[i + 1][j + 1]
        };
        Arrays.sort(tmp);

        return tmp[tmp.length - 1];
    }

    private int getMax2(int[][] grid, int i, int j) {
        int m1 = Math.max(grid[i][j], grid[i - 1][j]);
        int m2 = Math.max(m1, grid[i + 1][j]);
        int m3 = Math.max(m2, grid[i][j + 1]);
        int m4 = Math.max(m3, grid[i][j - 1]);
        int m5 = Math.max(m4, grid[i - 1][j - 1]);
        int m6 = Math.max(m5, grid[i + 1][j - 1]);
        int m7 = Math.max(m6, grid[i - 1][j + 1]);
        return Math.max(m7, grid[i + 1][j + 1]);
    }

}
