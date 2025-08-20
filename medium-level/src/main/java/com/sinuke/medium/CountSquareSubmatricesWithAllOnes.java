package com.sinuke.medium;

public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int maxSize = Math.min(matrix.length - i, matrix[0].length - j);
                for (int size = 1; size <= maxSize; size++) {
                    sum += isOnesOnly(matrix, i, j, size) ? 1 : 0;
                }
            }
        }

        return sum;
    }

    private boolean isOnesOnly(int[][] matrix, int i, int j, int size) {
        for (int r = i; r < i + size; r++) {
            for (int c = j; c < j + size; c++) {
                if (matrix[r][c] == 0) return false;
            }
        }
        return true;
    }

}
