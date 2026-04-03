package com.sinuke.easy;

public class LargestNumberAtLeastTwiceOfOthers {

    // 0 ms
    public int dominantIndex(int[] nums) {
        int max = nums[0] > nums[1] ? 0 : 1;
        int max2 = max == 0 ? 1 : 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max2 = max;
                max = i;
            } else if (nums[i] > nums[max2]) max2 = i;
        }

        return nums[max2] * 2 > nums[max] ? -1 : max;
    }

    // 0 ms
    public int dominantIndex2(int[] nums) {
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max]) max = i;
        }

        for (int num : nums) {
            if (num != nums[max] && num * 2 > nums[max]) return -1;
        }

        return max;
    }

}
