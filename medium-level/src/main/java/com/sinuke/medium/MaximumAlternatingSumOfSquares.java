package com.sinuke.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class MaximumAlternatingSumOfSquares {

    // 32 ms, 84.62%, 132 Mb
    public long maxAlternatingSum(int[] nums) {
        long score = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
            score += nums[i];
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length / 2; i++) {
            score -= nums[i];
            score -= nums[i];
        }

        return score;
    }

    // 130 ms, 5.63%, 155 Mb
    public long maxAlternatingSum2(int[] nums) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted(Comparator.comparingInt(a -> a * a))
                .mapToInt(Integer::intValue)
                .toArray();

        long score = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            score += (long) nums[r] * nums[r] - (long) nums[l] * nums[l];
            l++;
            r--;
        }

        if (l == r) score += (long) nums[l] * nums[l];
        return score;
    }

}
