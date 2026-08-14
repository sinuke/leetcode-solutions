package com.sinuke.easy;

import java.util.List;

public class MinimumOperationsToCollectElements {

    public int minOperations(List<Integer> nums, int k) {
        int[] a = new int[nums.size() + 1];
        int cnt = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (a[nums.get(i)] == 0 && nums.get(i) <= k) {
                a[nums.get(i)] = 1;
                cnt++;
            }

            if (cnt == k) return nums.size() - i;
        }

        return -1;
    }

}