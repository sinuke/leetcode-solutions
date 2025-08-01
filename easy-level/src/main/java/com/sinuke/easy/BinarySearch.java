package com.sinuke.easy;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (end >= start) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }

}
