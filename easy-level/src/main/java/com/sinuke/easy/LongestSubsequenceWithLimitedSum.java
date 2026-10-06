package com.sinuke.easy;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int[] res = new int[queries.length];
        int j = 0;
        for (int q : queries) {
            int i = 0, s = 0;
            while (i < nums.length && s <= q) {
                s += nums[i];
                i++;
            }
            res[j++] = s <= q ? i : i - 1;
        }
        return res;
    }

}
