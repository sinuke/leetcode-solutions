package com.sinuke.easy;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int even = 0, odd = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) ans[even++] = num;
            else ans[odd--] = num;
        }
        return ans;
    }

}
