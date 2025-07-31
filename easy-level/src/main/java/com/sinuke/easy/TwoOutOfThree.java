package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class TwoOutOfThree {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] dp = new int[101];
        for (int num : nums1) {
            if (dp[num] == 0) dp[num] = 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (dp[num] == 0) dp[num] = 2;
            else if (dp[num] == 1) {
                result.add(num);
                dp[num] = -1;
            }
        }

        for (int num : nums3) {
            if (dp[num] == 1 || dp[num] == 2) {
                result.add(num);
                dp[num] = -1;
            }
        }

        return result;
    }

}
