package com.sinuke.easy;

public class FindChampionI {

    public int findChampion(int[][] grid) {
        int max = -1, row = -1;
        for (int i = 0; i < grid.length; i++) {
            int cnt = 0;
            for (int j = 0; j < grid.length; j++) cnt += grid[i][j];
            if (cnt > max) {
                max = cnt;
                row = i;
            }
        }
        return row;
    }

}
