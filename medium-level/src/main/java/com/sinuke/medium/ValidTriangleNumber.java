package com.sinuke.medium;

import java.util.Arrays;

class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int counter = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int left = j + 1, right = nums.length;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j] && nums[i] < nums[mid] + nums[j] && nums[j] < nums[i] + nums[mid]) {
                        counter += mid - left + 1;
                        left = mid + 1;
                    } else right = mid;
                }
            }
        }

        return counter;
    }

}
