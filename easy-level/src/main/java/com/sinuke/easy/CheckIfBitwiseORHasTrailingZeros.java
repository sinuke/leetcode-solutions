package com.sinuke.easy;

public class CheckIfBitwiseORHasTrailingZeros {

    public boolean hasTrailingZeros(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                cnt++;
                if (cnt == 2) return true;
            }
        }
        return false;
    }

}
