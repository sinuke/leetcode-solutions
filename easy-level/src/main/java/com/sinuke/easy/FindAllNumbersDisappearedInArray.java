package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] counts = new int[nums.length];
        for (int num : nums) {
            counts[num - 1]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) result.add(i + 1);
        }

        return result;
    }

    // from LeetCode
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = - Math.abs(nums[index]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i + 1);
        }

        return result;
    }

}
