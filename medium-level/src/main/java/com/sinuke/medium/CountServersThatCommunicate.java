package com.sinuke.medium;

public class CountServersThatCommunicate {

    public int countServers(int[][] grid) {
        int total = 0;
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                total += grid[i][j];
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }

        int isolated = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && rows[i] == 1 && cols[j] == 1) isolated++;
            }
        }

        return total - isolated;
    }

}
