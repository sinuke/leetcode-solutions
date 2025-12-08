package com.sinuke.easy;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegersByBinaryReflection {

    public int[] sortByReflection(int[] nums) {
        int n = nums.length;
        Value[] vals = new Value[n];
        for (int i = 0; i < n; i++) {
            int bin = Integer.parseInt(new StringBuilder(Integer.toBinaryString(nums[i])).reverse().toString(), 2);
            vals[i] = new Value(bin, nums[i]);
        }

        Arrays.sort(vals, Comparator.<Value>comparingInt(v -> v.bin).thenComparing(v -> v.num));

        for (int i = 0; i < n; i++) {
            nums[i] = vals[i].num;
        }

        return nums;
    }

    private record Value(int bin, int num) {}

}
