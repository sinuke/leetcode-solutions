package com.sinuke.easy;

public class TrionicArrayI {

    public boolean isTrionic(int[] nums) {
        boolean s1 = false, s2 = false, s3 = true;
        int i = 0, n = nums.length, p = -1, q = -1;
        while (i < n - 1) {
            int next = nums[i + 1];

            if (p == -1) { // segment 1
                if (nums[i] >= next) {
                    p = i;
                    s1 = true;
                } else i++;
            } else if (q == -1) { // segment 2
                if (nums[i] <= next) {
                    q = i;
                    s2 = true;
                } else i++;
            } else { // segment 3
                if (nums[i] >= next) s3 = false;
                i++;
            }
        }

        if (nums[nums.length - 1] <= nums[nums.length - 2]) s3 = false;

        return p > 0 && q != -1 && q < n - 1 && p != q && s1 && s2 && s3;
    }

}
