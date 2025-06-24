package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInArray {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int j = Math.max(i - k, 0);
                while (j < nums.length && j <= i + k) {
                    dp[j]++;
                    j++;
                }
            }
        }

        List<Integer> result = new ArrayList<>(nums.length);
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != 0) result.add(i);
        }
        return result;
    }

}
