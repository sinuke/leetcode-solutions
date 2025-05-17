package com.sinuke.medium;

public class SortColors {

    public void sortColors(int[] nums) {
        int reds = 0, whites = 0;
        for (int num : nums) {
            reds += num == 0 ? 1 : 0;
            whites += num == 1 ? 1 : 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < reds) nums[i] = 0;
            else if (i < reds + whites) nums[i] = 1;
            else if (i >= reds + whites) nums[i] = 2;
        }
    }

}
