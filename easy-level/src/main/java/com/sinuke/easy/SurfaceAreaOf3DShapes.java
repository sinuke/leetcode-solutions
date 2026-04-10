package com.sinuke.easy;

public class SurfaceAreaOf3DShapes {

    public int surfaceArea(int[][] grid) {
        int n = grid.length, area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int p = grid[i][j];
                if (p != 0) {
                    area += 2;

                    area += (i == 0) ? p : 0;
                    area += (i == n - 1) ? p : 0;
                    area += (j == 0) ? p : 0;
                    area += (j == n - 1) ? p : 0;

                    if (i > 0 && grid[i - 1][j] < p) area += p - grid[i - 1][j];
                    if (i < n - 1 && grid[i + 1][j] < p) area += p - grid[i + 1][j];
                    if (j > 0 && grid[i][j - 1] < p) area += p - grid[i][j - 1];
                    if (j < n - 1 && grid[i][j + 1] < p) area += p - grid[i][j + 1];
                }
            }
        }
        return area;
    }

}
