package com.sinuke;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        int i = 0;
        int[] temp = new int[m + n];

        while (i < m + n) {
            if (index1 < m && index2 < n) {
                if (nums1[index1] < nums2[index2]) {
                    temp[i] = nums1[index1];
                    index1++;
                } else if (nums2[index2] < nums1[index1]) {
                    temp[i] = nums2[index2];
                    index2++;
                } else {
                    temp[i] = nums1[index1];
                    temp[i + 1] = nums2[index2];
                    index1++;
                    index2++;
                    i++;
                }
            } else if (index1 == m) {
                temp[i] = nums2[index2];
                index2++;
            } else if (index2 == n) {
                temp[i] = nums1[index1];
                index1++;
            }

            i++;
        }

        System.arraycopy(temp, 0, nums1, 0, m + n);
    }

}
