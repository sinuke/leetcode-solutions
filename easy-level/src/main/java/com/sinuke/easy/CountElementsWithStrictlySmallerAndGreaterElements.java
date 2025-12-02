package com.sinuke.easy;

import java.util.Arrays;

public class CountElementsWithStrictlySmallerAndGreaterElements {

    // 0 ms
    public int countElements(int[] nums) {
        int min = nums[0], max = nums[0], min_cnt = 1, max_cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min_cnt = 1;
                min = nums[i];
            } else if (nums[i] == min) min_cnt++;

            if (nums[i] > max) {
                max = nums[i];
                max_cnt = 1;
            } else if (nums[i] == max) max_cnt++;
        }

        return min_cnt + max_cnt > nums.length ? 0 : nums.length - min_cnt - max_cnt;
    }

    // 1 ms
    public int countElements2(int[] nums) {
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int cnt = 0;
        for (int num : nums) {
            if (num != min && num != max) cnt++;
        }

        return cnt;

    }

    // 5 ms
    public int countElements3(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0, min = nums[0], max = nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != min && nums[i] != max) cnt++;
        }

        return cnt;

    }

}
