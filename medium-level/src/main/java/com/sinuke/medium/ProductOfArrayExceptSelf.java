package com.sinuke.medium;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, prod = 1;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            prod *= nums[i];
            tmp[i] = prod;
        }

        prod = 1;
        for (int i = n - 1; i >= 0; i--) {
            int val = (i == 0 ? 1 : tmp[i - 1]) * prod;
            prod *= nums[i];
            nums[i] = val;
        }
        return nums;
    }

}
