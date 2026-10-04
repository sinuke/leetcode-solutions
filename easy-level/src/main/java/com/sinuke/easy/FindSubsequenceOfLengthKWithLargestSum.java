package com.sinuke.easy;

import java.util.Arrays;
import java.util.Comparator;

public class FindSubsequenceOfLengthKWithLargestSum {

    public int[] maxSubsequence(int[] nums, int k) {
        int[][] a = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }
        Arrays.sort(a, Comparator.<int[]>comparingInt(ar -> ar[0]).reversed());

        a = Arrays.copyOf(a, k);
        Arrays.sort(a, Comparator.comparingInt(ar -> ar[1]));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = a[i][0];
        }
        return res;
    }

}
