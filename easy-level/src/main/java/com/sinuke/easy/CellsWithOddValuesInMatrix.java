package com.sinuke.easy;

public class CellsWithOddValuesInMatrix {

    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int[] pair : indices) {
            rows[pair[0]] += 1;
            cols[pair[1]] += 1;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows[i] + cols[j]) % 2 != 0) count++;
            }
        }
        return count;
    }

}
