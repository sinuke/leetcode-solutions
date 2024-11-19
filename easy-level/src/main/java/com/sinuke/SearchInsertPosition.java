package com.sinuke;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        var result = -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            result = (low + high) / 2;
            int guess = nums[result];

            if (guess == target) {
                return result;
            } else if (guess > target) {
                high = result - 1;
            } else {
                low = result + 1;
                result++;
            }
        }

        return result;
    }

}
