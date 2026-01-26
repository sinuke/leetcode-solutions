package com.sinuke.easy;

public class FormSmallestNumberFromTwoDigitArrays {

    public int minNumber(int[] nums1, int[] nums2) {
        int[] n1 = new int[10];
        int[] n2 = new int[10];
        for (int j : nums1) n1[j] = 1;
        for (int j : nums2) n2[j] = 1;

        int result = 1;
        for (int i = 1; i < 99; i++) {
            if (i < 10) {
                if (n1[i] == 1 && n2[i] == 1) return i;
            } else {
                int d1 = i % 10, d2 = i / 10;
                if ((n1[d1] == 1 && n2[d2] == 1) || (n1[d2] == 1) && n2[d1] == 1) return i;
            }
        }

        return result;
    }

}
