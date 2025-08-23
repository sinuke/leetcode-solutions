package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowOrColumn {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[] {i, j});
            }
        }

        int[] rows = new int[m];
        int[] columns = new int[n];
        for (int i = 0; i < arr.length; i++) {
            var coords = map.get(arr[i]);
            rows[coords[0]]++;
            columns[coords[1]]++;
            if (rows[coords[0]] == n || columns[coords[1]] == m) return i;
        }

        return arr.length - 1;
    }

}
