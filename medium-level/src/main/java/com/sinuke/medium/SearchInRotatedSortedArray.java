package com.sinuke.medium;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                if (nums[start] < nums[mid] && nums[start] <= target) end = mid - 1;
                else if (nums[start] > nums[mid] && target <= nums[start] && nums[mid] > target) end = mid - 1;
                else start = mid + 1;
            } else {
                if (nums[start] > nums[mid] && target >= nums[start]) end = mid - 1;
                else start = mid + 1;
            }
        }

        return -1;
    }

}
