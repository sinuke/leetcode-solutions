package com.sinuke.easy;

public class SemiOrderedPermutation {
    public int semiOrderedPermutation(int[] nums) {
        int pos1 = -1, posn = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) pos1 = i;
            if (nums[i] == nums.length) posn = i;
        }
        return pos1 + (nums.length - posn) - 1 - ((pos1 > posn) ? 1 : 0);
    }
}
