package com.sinuke.easy;

public class MinimumMovesToEqualArrayElementsIII {

    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE, count = 0;
        for (int num : nums) max = Math.max(max, num);
        for (int num : nums) count += max - num;
        return count;
    }

}
