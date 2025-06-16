package com.sinuke.easy;

public class RowWithMaximumOnes {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] result = new int[2];
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;

            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }

            if (sum > result[1]) {
                result[0] = i;
                result[1] = sum;
            }
        }

        return result;
    }

}
