package com.sinuke.easy;

import java.util.List;

public class MinimumPositiveSumSubarray {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int curr = 0;
            for (int j = i; j < i + r && j < nums.size(); j++) {
                curr += nums.get(j);
                if (j - i + 1>= l && j - i + 1 <= r && curr > 0 && curr < sum) sum = curr;
            }
        }
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }

}
