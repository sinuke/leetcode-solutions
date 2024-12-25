package com.sinuke.easy;

public class RangeSumQueryImmutable {

    public static class NumArray {

        private final int[] sums;

        public NumArray(int[] nums) {
            this.sums = new int[nums.length + 1];
            if (nums.length == 0) return;

            sums[0] = nums[0];
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }

    }

}
