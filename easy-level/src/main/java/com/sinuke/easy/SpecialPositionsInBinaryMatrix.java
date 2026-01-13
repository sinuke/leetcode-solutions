package com.sinuke.easy;

public class SpecialPositionsInBinaryMatrix {

    // 3 ms
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rSum = new int[m], cSum = new int[n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                rSum[r] += mat[r][c];
                cSum[c] += mat[r][c];
            }
        }

        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 1 && rSum[r] == 1 && cSum[c] == 1) count++;
            }
        }

        return count;
    }

}
