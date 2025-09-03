package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, r = 0, c = 0, rd = 0, cd = 0;
        List<Integer> res = new ArrayList<>(n * m);

        for (int i = 0; i < m * n; i++) {
            res.add(matrix[r][c]);

            if (r == rd && c < n - cd - 1) c++;
            else if (c == n - cd - 1 && r < m - rd - 1) r++;
            else if (c > cd && r == m - rd - 1 && r > rd) c--;
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

        return res;
    }

}
