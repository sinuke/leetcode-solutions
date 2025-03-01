package com.sinuke.easy;

public class ApplyOperationsToArray {

    public int[] applyOperations(int[] nums) {
        int i = 0, j = 0;
        int[] result = new int[nums.length];

        while (i < nums.length) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                if (nums[i] != 0) result[j++] = nums[i] * 2;
                i++;
            } else if (nums[i] != 0) result[j++] = nums[i];

            i++;
        }

        return result;
    }

}
