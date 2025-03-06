package com.sinuke.easy;

public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] nums = new int[n * n];
        var result = new int[2];

        for (int[] values : grid) {
            for (int value : values) {
                nums[value - 1]++;
                if (nums[value - 1] > 1) result[0] = value;
            }
        }

        for (int i = 0; i < n * n; i++) {
            if (nums[i] == 0) {
                result[1] = i + 1;
                break;
            }
        }

        return result;
    }

}
