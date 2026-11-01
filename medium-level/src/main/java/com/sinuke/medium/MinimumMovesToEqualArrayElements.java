package com.sinuke.medium;

public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) min = Math.min(min, num);

        int cnt = 0;
        for (int num : nums) cnt += num - min;
        return cnt;
    }

}
