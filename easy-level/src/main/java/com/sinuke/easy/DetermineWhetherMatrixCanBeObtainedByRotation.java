package com.sinuke.easy;

public class DetermineWhetherMatrixCanBeObtainedByRotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int k = 0; k < 4; k++) {
            int[][] m = new int[n][n];

            boolean req = true;
            for (int i = 0; i < n; i++) {
                boolean eq = true;
                for (int j = 0; j < n; j++) {
                    m[i][j] = mat[j][n - i - 1];
                    if (target[i][j] != m[i][j]) eq = false;
                }
                if (!eq) req = false;
            }
            if (req) return true;

            for (int i = 0; i < n; i++) {
                System.arraycopy(m[i], 0, mat[i], 0, n);
            }

        }

        return false;
    }

}
