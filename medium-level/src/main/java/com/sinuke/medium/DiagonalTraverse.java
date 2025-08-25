package com.sinuke.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(mat[i][j]);
                max = Math.max(max, i + j);
            }
        }

        int[] arr = new int[m * n];
        int k = 0;
        for (int i = 0; i <= max; i++) {
            var list = map.get(i);
            if (i % 2 == 0) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    arr[k++] = list.get(j);
                }
            } else {
                for (int integer : list) {
                    arr[k++] = integer;
                }
            }
        }

        return arr;
    }

}
