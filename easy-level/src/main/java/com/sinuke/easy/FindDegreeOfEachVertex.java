package com.sinuke.easy;

public class FindDegreeOfEachVertex {

    public int[] findDegrees(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[0][i] += matrix[i][j];
                if (i == 0 && j != 0) matrix[i][j] = 0;
            }
        }
        return matrix[0];
    }

}
