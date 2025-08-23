package com.sinuke.easy;

public class CheckIfEveryRowAndColumnContainsAllNumbers {

    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        byte[][] rows = new byte[n][n];
        byte[][] columns = new byte[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int d = matrix[r][c] - 1;

                if (rows[r][d] == 1) return false;
                else rows[r][d]++;

                if (columns[c][d] == 1) return false;
                else columns[c][d]++;
            }
        }

        return true;
    }

}
