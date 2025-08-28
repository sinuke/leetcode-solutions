package com.sinuke.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortMatrixByDiagonals {

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(i - j, new PriorityQueue<>(i - j < 0 ? Comparator.comparingInt(val -> val) : Comparator.reverseOrder()));
                map.get(i - j).offer(grid[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = map.get(i - j).poll();
            }
        }
        return grid;
    }

}
