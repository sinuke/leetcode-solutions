package com.sinuke.easy;

public class MatrixSimilarityAfterCyclicShifts {

    public boolean areSimilar(int[][] mat, int k) {
        int[][] shifted = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                shifted[i][j] = mat[i][j];
            }
        }

        k = k % mat[0].length;
        while (k > 0) {
            shift(shifted);
            k--;
        }

        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (shifted[i][j] != mat[i][j]) return false;
            }
        }
        return true;
    }

    private void shift(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (i % 2 == 0) {
                int tmp = mat[i][0];
                System.arraycopy(mat[i], 1, mat[i], 0, mat[i].length - 1);
                mat[i][mat[i].length - 1] = tmp;
            } else {
                int tmp = mat[i][mat[i].length - 1];
                System.arraycopy(mat[i], 0, mat[i], 1, mat[i].length - 1);
                mat[i][0] = tmp;
            }
        }
    }

}
