package com.sinuke.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MatrixCellsInDistanceOrder {

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i * cols + j][0] = i;
                result[i * cols + j][1] = j;
            }
        }

        Arrays.sort(result, Comparator.<int[]>comparingInt(p -> Math.abs(p[0] - rCenter) + Math.abs(p[1] - cCenter)));

        return result;
    }

}
