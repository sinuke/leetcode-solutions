package com.sinuke.easy;

public class FindTheIntegerAddedToArrayI {

    public int addedInteger(int[] nums1, int[] nums2) {
        int min1 = 1001, min2 = 1001;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] < min1) min1 = nums1[i];
            if (nums2[i] < min2) min2 = nums2[i];
        }

        return min2 - min1;
    }

}
