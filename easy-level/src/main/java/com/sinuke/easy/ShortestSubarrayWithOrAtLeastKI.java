package com.sinuke.easy;

class ShortestSubarrayWithOrAtLeastKI {

    public int minimumSubarrayLength(int[] nums, int k) {
        int l = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int xor = nums[i];
            if (xor >= k) return 1;

            for (int j = i + 1; j < nums.length; j++) {
                xor |= nums[j];
                if (xor >= k) l = Math.min(l, j - i + 1);
            }
        }
        return l == Integer.MAX_VALUE ? -1 : l;
    }

}
