package com.sinuke.medium;

public class NumberOfWaysToSplitArray {

    // 3 ms
    public int waysToSplitArray(int[] nums) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (prefix[i + 1] >= prefix[nums.length] - prefix[i + 1]) result++;
        }
        return result;
    }

    // 2 ms
    public int waysToSplitArray2(int[] nums) {
        long total = 0;
        for (var num : nums) {
            total += num;
        }

        int result = 0;
        long current = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            current += nums[i];
            if (current >= total - current) result++;
        }
        return result;
    }

}
