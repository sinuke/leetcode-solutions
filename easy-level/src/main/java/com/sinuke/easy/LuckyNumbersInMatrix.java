package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInMatrix {

    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] mins = new int[m];
        int[] maxs = new int[n];

        for (int i = 0; i < m; i++) {
            mins[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < mins[i]) mins[i] = matrix[i][j];
                if (matrix[i][j] > maxs[j]) maxs[j] = matrix[i][j];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mins[i] == maxs[j]) {
                    result.add(mins[i]);
                    break;
                }
            }
        }
        return result;
    }

}
