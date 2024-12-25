package com.sinuke.easy;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        int j = -1;
        for (int num : nums) {
            if (num != 0) temp[++j] = num;
        }

        System.arraycopy(temp, 0, nums, 0, temp.length);
    }

}
