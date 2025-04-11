package com.sinuke.easy;

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0, j = -1, indx = 0;

        while (i < nums.length) {
            if (nums[i] < 0) j++;
            else if (nums[i] == 0) result[indx++] = nums[i];
            else {
                if (j >= 0 && nums[i] >= Math.abs(nums[j])) {
                    result[indx++] = nums[j] * nums[j];
                    result[indx++] = nums[i] * nums[i];
                    j--;
                } else result[indx++] = nums[i] * nums[i];
            }
            i++;
        }

        return result;
    }

}
