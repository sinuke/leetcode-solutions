package com.sinuke.easy;

public class ModifyTheMatrix {

    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] maxs = new int[n];
        for (int j = 0; j < n; j++) {
            for (int[] ints : matrix) {
                maxs[j] = Math.max(maxs[j], ints[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = maxs[j];
            }
        }

        return matrix;
    }

}
