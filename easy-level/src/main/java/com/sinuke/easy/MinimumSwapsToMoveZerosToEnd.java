package com.sinuke.easy;

public class MinimumSwapsToMoveZerosToEnd {

    public int minimumSwaps(int[] nums) {
        int cnt = 0, n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            cnt += (nums[i] == 0) ? 1 : 0;
        }
        int total = cnt;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0 && n - i - total <= 0) cnt--;
        }

        return cnt;
    }

}
