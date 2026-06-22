package com.sinuke.easy;

import java.util.Arrays;

public class CreateGridWithExactlyOnePath {

    // 1 ms
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        char[] c = new char[n];
        Arrays.fill(c, '.');
        res[0] = new String(c);
        for (int i = 1; i < m; i++) {
            c = new char[n];
            Arrays.fill(c, 0, n, '#');
            c[n - 1] = '.';
            res[i] = new String(c);
        }
        return res;
    }

    // 3 ms
    public String[] createGrid2(int m, int n) {
        String[] res = new String[m];
        for (int i = 0; i < m; i++) {
            var sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) sb.append('.');
                else sb.append('#');
            }
            res[i] = sb.toString();
        }
        return res;
    }

}
