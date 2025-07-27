package com.sinuke.easy;

public class CountHillsAndValleysInArray {

    public int countHillValley(int[] nums) {
        boolean hill = false, valley = false;
        int count = 0, prev = nums[0], i = 1;
        while (i < nums.length - 1) {
            if ((nums[i] > prev && nums[i] > nums[i + 1]) || (nums[i] < prev && nums[i] < nums[i + 1]) || (nums[i] == prev && ((nums[i] > nums[i + 1] && hill) || (nums[i] < nums[i + 1] && valley)))) {
                hill = false;
                valley = false;
                count++;
            }
            else if (nums[i] > prev && nums[i] == nums[i + 1]) {
                hill = true;
                valley = false;
            } else if (nums[i] < prev && nums[i] == nums[i + 1]) {
                valley = true;
                hill = false;
            }
            prev = nums[i];
            i++;
        }

        return count;
    }

}
