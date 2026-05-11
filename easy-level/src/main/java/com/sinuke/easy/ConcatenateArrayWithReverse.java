package com.sinuke.easy;

public class ConcatenateArrayWithReverse {

    public int[] concatWithReverse(int[] nums) {
        int[] res = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i + nums.length] = nums[nums.length - i - 1];
        }
        return res;
    }

}
