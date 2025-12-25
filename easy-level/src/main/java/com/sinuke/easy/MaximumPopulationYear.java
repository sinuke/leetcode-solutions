package com.sinuke.easy;

public class MaximumPopulationYear {

    // 3 ms
    public int maximumPopulation(int[][] logs) {
        int[] counts = new int[100];
        int max = 0;
        for (int[] log : logs) {
            for (int y = log[0]; y < log[1]; y++) {
                counts[y - 1950]++;
                if (counts[max] < counts[y - 1950] || (counts[max] == counts[y - 1950] && y - 1950 < max))
                    max = y - 1950;
            }
        }
        return max + 1950;
    }

    // 0 ms - from LeetCode
    public int maximumPopulation2(int[][] logs) {
        int[] counts = new int[101];
        for (int[] log : logs) {
            counts[log[0] - 1950]++;
            counts[log[1] - 1950]--;
        }

        int max = 0;
        for (int i = 1; i < 100; i++) {
            counts[i] += counts[i - 1];
            if (counts[i] > counts[max]) max = i;
        }

        return max + 1950;
    }

}
