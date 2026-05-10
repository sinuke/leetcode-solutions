package com.sinuke.easy;

public class MoveZeroes {

    // 2 ms
    public void moveZeroes(int[] nums) {
        int s = 0, f = 0;
        while (f < nums.length) {
            if (nums[f] != 0) {
                int tmp = nums[s];
                nums[s] = nums[f];
                nums[f] = tmp;

                s++;
            }
            f++;
        }
    }

    // 1 ms
    public void moveZeroes2(int[] nums) {
        int[] temp = new int[nums.length];
        int j = -1;
        for (int num : nums) {
            if (num != 0) temp[++j] = num;
        }

        System.arraycopy(temp, 0, nums, 0, temp.length);
    }

}
