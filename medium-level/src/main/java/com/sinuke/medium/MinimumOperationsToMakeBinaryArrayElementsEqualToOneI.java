package com.sinuke.medium;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {

    public int minOperations(int[] nums) {
        int flipsCount = 0, onesCount = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                flipsCount++;
            }

            onesCount++;
        }

        return nums[nums.length - 2] == 1 && nums[nums.length - 1] == 1 && onesCount == nums.length - 2 ? flipsCount : -1;
    }

}
