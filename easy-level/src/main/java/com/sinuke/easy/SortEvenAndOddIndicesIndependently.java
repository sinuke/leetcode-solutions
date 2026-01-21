package com.sinuke.easy;

import java.util.Arrays;

public class SortEvenAndOddIndicesIndependently {

    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length, i = 0, j = 0, k = 0;
        int[] even = new int[n % 2 == 0 ? n / 2 : n / 2 + 1];
        int[] odd = new int[n / 2];

        while (i < n) {
            if (j < even.length) even[j++] = nums[i++];
            if (k < odd.length) odd[k++] = nums[i++];
        }

        Arrays.sort(even);
        Arrays.sort(odd);

        i = 0;
        j = 0;
        k = odd.length - 1;
        while (i < n) {
            if (j < even.length) nums[i++] = even[j++];
            if (k >= 0) nums[i++] = odd[k--];
        }

        return nums;
    }

}
