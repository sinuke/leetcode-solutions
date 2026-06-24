package com.sinuke.easy;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public int specialArray(int[] nums) {
        int[] xs = new int[nums.length + 1];
        for (int x = 1; x < xs.length; x++) {
            for (int num : nums) {
                if (num >= x) xs[x]++;
            }
        }

        for (int x = 1; x < xs.length; x++) {
            if (xs[x] == x) return x;
        }
        return -1;
    }
}
