package com.sinuke.easy;

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        long[] max = new long[3];
        max[0] = Long.MIN_VALUE;
        max[1] = Long.MIN_VALUE;
        max[2] = Long.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            if (max[0] < num) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
                if (count < 3) count++;
            }
            else if (max[1] < num && max[0] > num) {
                max[2] = max[1];
                max[1] = num;
                if (count < 3) count++;
            }
            else if (max[2] < num && max[1] > num) {
                max[2] = num;
                if (count < 3) count++;
            }
        }

        return count == 3 ? ((Long) max[2]).intValue() : ((Long) max[0]).intValue();
    }

}
