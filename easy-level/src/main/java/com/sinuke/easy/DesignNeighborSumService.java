package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class DesignNeighborSumService {

    public static class NeighborSum {

        private final Map<Integer, Integer> asum = new HashMap<>();
        private final Map<Integer, Integer> dsum = new HashMap<>();

        public NeighborSum(int[][] grid) {
            int n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    asum.put(grid[i][j], getASum(grid, i, j));
                    dsum.put(grid[i][j], getDSum(grid, i, j));
                }
            }
        }

        public int adjacentSum(int value) {
            return asum.get(value);
        }

        public int diagonalSum(int value) {
            return dsum.get(value);
        }

        private int getASum(int[][] grid, int i, int j) {
            int sum = 0;
            if (i != 0) sum += grid[i - 1][j];
            if (j != 0) sum += grid[i][j - 1];
            if (i != grid.length - 1) sum += grid[i + 1][j];
            if (j != grid.length - 1) sum += grid[i][j + 1];
            return sum;
        }

        private int getDSum(int[][] grid, int i, int j) {
            int sum = 0;
            if (i != 0 && j != 0) sum += grid[i - 1][j - 1];
            if (i != 0 && j != grid.length - 1) sum += grid[i - 1][j + 1];
            if (i != grid.length - 1 && j != 0) sum += grid[i + 1][j - 1];
            if (i != grid.length - 1 && j != grid.length - 1) sum += grid[i + 1][j + 1];
            return sum;
        }

    }

}
