package com.sinuke.easy;

public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        int length = 0, i = 0;
        while (i < nums.length - 1) {
            length += nums[i];
            i += 2;
        }

        int[] result = new int[length];
        i = 1;
        int indx = 0;
        while (i < nums.length) {
            int cnt = nums[i - 1];
            while (cnt > 0) {
                result[indx] = nums[i];
                indx++;
                cnt--;
            }
            i += 2;
        }

        return result;
    }

}
