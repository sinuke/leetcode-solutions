package com.sinuke.easy;

public class CheckIfArrayIsGood {

    public boolean isGood(int[] nums) {
        int[] a = new int[201];
        int max = nums[0];
        a[max] = 1;

        for (int i = 1; i < nums.length; i++) {
            a[nums[i]]++;
            max = Math.max(max, nums[i]);
        }

        boolean isPerm = true;
        for (int i = 1; i < max; i++) {
            if (a[i] != 1) {
                isPerm = false;
                break;
            }
        }

        return isPerm && a[max] == 2 && nums.length == max + 1;
    }

}
