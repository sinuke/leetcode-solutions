package com.sinuke.medium;

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int s = nums.length;
        int f = nums.length;

        do {
            s = nums[s - 1];
            f = nums[nums[f - 1] - 1];
        } while (s != f);

        f = nums.length;
        do {
            s = nums[s - 1];
            f = nums[f - 1];
        } while (s != f);

        return s;
    }

}
