package com.sinuke.easy;

import java.util.Arrays;
import java.util.Comparator;

public class RankTransformOfArray {

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = arr[i];
            nums[i][1] = i;
        }

        Arrays.sort(nums, Comparator.<int[]>comparingInt(i -> i[0]));

        int r = 0;
        for (int i = 0; i < n; i++) {
            arr[nums[i][1]] = i == 0 || nums[i - 1][0] != nums[i][0] ? ++r : r;
        }

        return arr;
    }

}
