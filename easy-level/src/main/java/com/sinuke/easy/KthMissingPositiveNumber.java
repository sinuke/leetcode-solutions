package com.sinuke.easy;

public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int j = 0, counter = 0;
        for (int i = 1; i < 2001; i++) {
            if (j >= arr.length || i != arr[j]) counter++;
            else j++;
            if (counter == k) return i;
        }
        return k;
    }

}
