package com.sinuke.easy;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {

    // 9 ms
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

    // 9 ms
    public int[] answerQueries2(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int[] p = new int[nums.length];
        p[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            p[i] = p[i - 1] + nums[i];
        }

        int[] res = new int[queries.length];
        int j = 0;
        for (int q : queries) {
            int k = search(p, q);
            res[j++] = k == -1 ? 0 : k + 1;
        }
        return res;
    }

    private int search(int[] p, int q) {
        int start = 0, end = p.length - 1;

        while (end >= start) {
            int mid = (start + end) / 2;
            if (p[mid] == q) return mid;
            else if (p[mid] > q) end = mid - 1;
            else start = mid + 1;
        }

        return start > 0 && p[start - 1] < q ? start - 1 : -1;
    }

}
