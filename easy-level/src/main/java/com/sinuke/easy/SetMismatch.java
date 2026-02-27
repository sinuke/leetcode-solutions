package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length, expectedSum = n * (n + 1) / 2;
        int actualSum = 0, duplicate = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) duplicate = num;
            else set.add(num);
            actualSum += num;
        }
        return new int[] {duplicate, expectedSum - actualSum + duplicate};
    }

}
