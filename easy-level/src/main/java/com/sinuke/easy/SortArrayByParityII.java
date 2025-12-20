package com.sinuke.easy;

public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
        int even = 0, odd = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[even] = num;
                even += 2;
            } else {
                ans[odd] = num;
                odd += 2;
            }
        }
        return ans;
    }

}
