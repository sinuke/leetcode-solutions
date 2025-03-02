package com.sinuke.easy;

import java.util.Arrays;

public class MergeTwo2DArraysBySummingValues {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i1 = 0, i2 = 0, index = 0;
        int[][] result = new int[nums1.length + nums2.length][2];

        while (i1 < nums1.length || i2 < nums2.length) {
            if (i1 >= nums1.length && i2 < nums2.length) {
                result[index][0] = nums2[i2][0];
                result[index][1] = nums2[i2][1];
                index++;
                i2++;
            } else if (i2 >= nums2.length && i1 < nums1.length) {
                result[index][0] = nums1[i1][0];
                result[index][1] = nums1[i1][1];
                index++;
                i1++;
            } else {
                if (nums1[i1][0] < nums2[i2][0]) {
                    result[index][0] = nums1[i1][0];
                    result[index][1] = nums1[i1][1];
                    index++;
                    i1++;
                } else if (nums2[i2][0] < nums1[i1][0]) {
                    result[index][0] = nums2[i2][0];
                    result[index][1] = nums2[i2][1];
                    index++;
                    i2++;
                } else if (nums1[i1][0] == nums2[i2][0]) {
                    result[index][0] = nums1[i1][0];
                    result[index][1] = nums1[i1][1] + nums2[i2][1];
                    index++;
                    i1++;
                    i2++;
                }
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }

}
