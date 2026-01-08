package com.sinuke.easy;

import java.util.Arrays;

public class DeleteGreatestValueInEachRow {

    public int deleteGreatestValue(int[][] grid) {
        for (int[] row : grid) Arrays.sort(row);

        int sum = 0;
        for (int col = grid[0].length - 1; col >= 0 ; col--) {
            int max = 0;
            for (int row = 0; row < grid.length; row++) max = Math.max(max, grid[row][col]);
            sum += max;
        }

        return sum;
    }

}
