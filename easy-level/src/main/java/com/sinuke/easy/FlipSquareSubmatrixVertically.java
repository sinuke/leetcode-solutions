package com.sinuke.easy;

public class FlipSquareSubmatrixVertically {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int start = x, end = x + k - 1;
        while (start < end) {
            for (int i = y; i < y + k; i++) {
                int tmp = grid[start][i];
                grid[start][i] = grid[end][i];
                grid[end][i] = tmp;
            }
            start++;
            end--;
        }
        return grid;
    }

}
