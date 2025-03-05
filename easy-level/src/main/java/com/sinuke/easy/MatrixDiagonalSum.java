package com.sinuke.easy;

public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        boolean skipCenter = mat.length % 2 != 0;

        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            if (mat.length - i - 1 != i || !skipCenter) sum += mat[i][mat.length - i - 1];
        }

        return sum;
    }

}
