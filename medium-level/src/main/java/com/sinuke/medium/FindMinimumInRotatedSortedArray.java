package com.sinuke.medium;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];

        int start = 0, end = nums.length - 1;
        while (end - start > 1) {
            int mid = (start + end) / 2;
            if (nums[start] >= nums[mid]) end = mid;
            else if (nums[end] <= nums[mid]) start = mid;
        }
        return nums[((start + end) / 2) + 1];
    }

}
