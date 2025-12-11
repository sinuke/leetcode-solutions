package com.sinuke.easy;

public class CheckIfItIsStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;

        int x1 = coordinates[0][0], y1 = coordinates[0][1];
        int x2 = coordinates[coordinates.length - 1][0], y2 = coordinates[coordinates.length - 1][1];

        for (int i = 1; i < coordinates.length - 1; i++) {
            int x3 = coordinates[i][0], y3 = coordinates[i][1];
            if ((x3 - x1) * (y2 - y1) != (y3 - y1) * (x2 - x1)) return false;
        }
        return true;
    }

}
