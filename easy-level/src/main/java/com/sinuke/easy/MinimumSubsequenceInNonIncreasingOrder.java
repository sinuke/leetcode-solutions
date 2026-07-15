package com.sinuke.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceInNonIncreasingOrder {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) sum += num;

        List<Integer> list = new ArrayList<>(nums.length);
        int i = nums.length - 1, sum2 = 0;
        while (i >= 0 && sum2 <= sum) {
            list.add(nums[i]);
            sum2 += nums[i];
            sum -= nums[i];
            i--;
        }

        return list;
    }

}
