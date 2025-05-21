package com.sinuke.medium;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> lines = new HashSet<>(m);
        Set<Integer> rows = new HashSet<>(n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    lines.add(i);
                    rows.add(j);
                }
            }
        }

        lines.forEach(line -> {
            for (int i = 0; i < n; i++) matrix[line][i] = 0;
        });
        rows.forEach(row -> {
            for (int i = 0; i < m; i++) matrix[i][row] = 0;
        });
    }

}
