package com.sinuke.easy;

public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) return mat;

        int[][] result = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int k = mat[0].length * i + j;
                result[k / c][k % c] = mat[i][j];
            }
        }

        return result;
    }

}
