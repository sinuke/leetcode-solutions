package com.sinuke.easy;

public class MakeSquareWithSameColor {

    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                if (atLeastThree(grid, i, j)) return true;
            }
        }

        return false;
    }

    private boolean atLeastThree(char[][] grid, int i, int j) {
        int w = 0, b = 0;

        if (grid[i][j] == 'B') w++;
        else b++;

        if (grid[i + 1][j] == 'B') w++;
        else b++;

        if (grid[i][j + 1] == 'B') w++;
        else b++;

        if (grid[i + 1][j + 1] == 'B') w++;
        else b++;

        return w > 2 || b > 2;
    }

}
