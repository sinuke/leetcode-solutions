package com.sinuke.medium;

public class DifferenceBetweenOnesAndZerosInRowAndColumn {

    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[] onesRow = new int[n], onesCol = new int[m];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = onesRow[i] + onesCol[j] - (n - onesRow[i]) - (m - onesCol[j]);
            }
        }
        return grid;
    }

}
