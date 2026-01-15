package com.sinuke.easy;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) != diff) return false;
        }
        return true;
    }

}
