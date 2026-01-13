package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class MaxPairSumInArray {

    // 4 ms
    public int maxSum(int[] nums) {
        int[][] digits = new int[10][2];
        int ans = -1;

        for (int num : nums) {
            int n = num, d = 0;

            while (n > 0) {
                d = Math.max(n % 10, d);
                n /= 10;
            }

            if (digits[d][0] <= num) {
                digits[d][1] = digits[d][0];
                digits[d][0] = num;
            } else if (digits[d][1] < num) digits[d][1] = num;

            if (digits[d][0] != 0 && digits[d][1] != 0) {
                ans = Math.max(digits[d][0] + digits[d][1], ans);
            }
        }

        return ans;
    }

    // 4 ms
    public int maxSum2(int[] nums) {
        List<Integer>[] dd = new List[10];

        for (int num : nums) {
            int n = num, max = 0;
            while (n > 0) {
                int d = n % 10;
                max = Math.max(max, d);
                n /= 10;
            }

            if (dd[max] == null) dd[max] = new ArrayList<>();
            dd[max].add(num);
        }

        int ans = -1;
        for (int i = 9; i >= 0; i--) {
            if (dd[i] != null && dd[i].size() > 1) {
                int first = 0, second = 0;

                for (int j = 0; j < dd[i].size(); j++) {
                    if (dd[i].get(j) >= first) {
                        second = first;
                        first = dd[i].get(j);
                    } else if (dd[i].get(j) > second) second = dd[i].get(j);
                }

                ans = Math.max(first + second, ans);
            }
        }

        return ans;
    }

}
