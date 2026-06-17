package com.sinuke.easy;

public class CheckIfAllIntegersInRangeAreCovered {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] a = new int[51];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) a[i]++;
        }

        for (int i = left; i <= right; i++) {
            if (a[i] == 0) return false;
        }

        return true;
    }

}
