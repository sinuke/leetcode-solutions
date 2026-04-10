package com.sinuke.easy;

public class ProjectionAreaOf3DShapes {

    public int projectionArea(int[][] grid) {
        int n = grid.length, p1 = 0, p2 = 0, p3 = 0;
        for (int i = 0; i < n; i++) {
            int rmax = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    p1++;
                }
                rmax = Math.max(rmax, grid[i][j]);
            }
            p2 += rmax;
        }

        for (int j = 0; j < n; j++) {
            int cmax = 0;
            for (int i = 0; i < n; i++) {
                cmax = Math.max(cmax, grid[i][j]);
            }
            p3 += cmax;
        }

        return p1 + p2 + p3;
    }

}
