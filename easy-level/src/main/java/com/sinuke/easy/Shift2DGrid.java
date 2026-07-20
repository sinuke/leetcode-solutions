package com.sinuke.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length, l = m * n;
        int[] a = new int[l];
        for (int i = 0; i < n; i++) {
            System.arraycopy(grid[i], 0, a, i * m, m);
        }

        k = k % l;
        int cnt = l, i = a.length - k, indx = 0;

        while (cnt > 0) {
            int r = indx / m;
            int c = indx % m;
            if (i >= a.length) i = 0;
            grid[r][c] = a[i];
            indx++;
            cnt--;
            i++;
        }

        return Arrays.stream(grid)
                .map(row -> Arrays.stream(row)
                        .boxed()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
