package com.sinuke.easy;

public class SignOfTheProductOfArray {

    public int arraySign(int[] nums) {
        int p = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            else p *= num < 0 ? -1 : 1;
        }

        return p;
    }

}
