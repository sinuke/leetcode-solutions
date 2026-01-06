package com.sinuke.medium;

public class MaximumMatrixSum {

    public long maxMatrixSum(int[][] matrix) {
        int negCount = 0, n = matrix.length, least = 100001;
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];

                if (val < 0) {
                    negCount++;
                    val =- val;
                }

                sum += val;
                if (val < least) least = val;
            }
        }

        return (negCount % 2 == 0) ? sum : (sum - 2L * least);
    }

}
