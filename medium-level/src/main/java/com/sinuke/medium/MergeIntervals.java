package com.sinuke.medium;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int i = 1, k = 0;
        while (i < intervals.length) {
            if (intervals[i][0] <= intervals[k][1]) intervals[k][1] = Math.max(intervals[i][1], intervals[k][1]);
            else intervals[++k] = intervals[i];
            i++;
        }

        return Arrays.copyOf(intervals, k + 1);
    }

}
