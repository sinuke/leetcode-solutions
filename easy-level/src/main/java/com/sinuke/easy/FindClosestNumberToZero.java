package com.sinuke.easy;

public class FindClosestNumberToZero {

    public int findClosestNumber(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            if ((Math.abs(num) < Math.abs(result)) || (Math.abs(num) == Math.abs(result) && num > result)) result = num;
        }
        return result;
    }

}
