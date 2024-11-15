package com.sinuke;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int result = 0;

        while (i < nums.length) {
            var value = nums[i];

            do {
                i++;
            } while (i < nums.length && value == nums[i]);

            nums[result] = value;
            result++;
        }

        return result;
    }

}
