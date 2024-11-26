package com.sinuke;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int middle = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>(middle + 1);
        int left = 0;
        int right = nums.length - 1;
        int result = nums[left];

        while (left <= right) {
            if (map.containsKey(nums[left])) {
                if (map.get(nums[left]) == middle) return nums[left];
                map.put(nums[left], map.get(nums[left]) + 1);
            } else map.put(nums[left], 1);

            if (map.containsKey(nums[right]) && left != right) {
                if (map.get(nums[right]) == middle) return nums[right];
                map.put(nums[right], map.get(nums[right]) + 1);
            } else if (left != right) map.put(nums[right], 1);

            left++;
            right--;
        }

        return result;
    }

    public int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // from LeetCode solutions
    public int majorityElementVote(int[] nums) {
        int result = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) result = num;
            if (num == result) count++;
            else count--;
        }

        return result;
    }

}
