package com.sinuke.easy;

public class CheckIfMatrixIsXMatrix {

    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if ((isDiagonal(row, col, n) && grid[row][col] == 0) || (!isDiagonal(row, col, n) && grid[row][col] != 0)) return false;
            }
        }
        return true;
    }

    private boolean isDiagonal(int r, int c, int n) {
        return r == c || r + c == n - 1;
    }

}
