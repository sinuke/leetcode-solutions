package com.sinuke.medium;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        int[] a = new int[l];
        System.arraycopy(nums, 0, a, 0, l);

        k = k % l;
        int cnt = l, i = l - k, indx = 0;

        while (cnt > 0) {
            if (i >= a.length) i = 0;
            nums[indx] = a[i];
            indx++;
            cnt--;
            i++;
        }
    }
}
