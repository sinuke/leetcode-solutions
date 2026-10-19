package com.sinuke.easy;

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev = 0, cur = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) cur++;
            else {
                prev = cur;
                cur = 1;
            }

            if (cur >= 2 * k || Math.min(prev, cur) >= k) return true;
        }

        return false;
    }

}
