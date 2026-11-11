package com.sinuke.medium;

import java.util.Arrays;
import java.util.Random;

public class DesignShuffleArray {

    public static class Solution {

        private final int[] nums;
        private final Random rand;

        public Solution(int[] nums) {
            this.nums = nums;
            this.rand = new Random();
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] result = Arrays.copyOf(nums, nums.length);
            for (int i = nums.length - 1; i >= 0; i--) {
                int j = rand.nextInt(nums.length);
                if (i != j) {
                    int tmp = result[i];
                    result[i] = result[j];
                    result[j] = tmp;
                }
            }
            return result;
        }
    }

}
