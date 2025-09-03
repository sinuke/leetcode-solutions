package com.sinuke.medium;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int r = 0, c = 0, rd = 0, cd = 0;

        for (int i = 1; i <= n * n; i++) {
            mat[r][c] = i;

            if (r == rd && c < n - cd - 1) c++;
            else if (c == n - cd - 1 && r < n - rd - 1) r++;
            else if (c > cd && r == n - rd - 1 && r > rd) c--;
            else if (c == cd && r > rd) {
                r--;
                if (r == rd) {
                    rd++;
                    cd++;
                    c = cd;
                    r = rd;
                }
            }
        }

        return mat;
    }

}
