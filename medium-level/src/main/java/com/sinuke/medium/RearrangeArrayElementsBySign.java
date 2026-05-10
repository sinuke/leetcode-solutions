package com.sinuke.medium;

public class RearrangeArrayElementsBySign {

    // 3 ms
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int pi = 0, ni = 1;
        for (int num : nums) {
            if (num > 0) {
                result[pi] = num;
                pi += 2;
            } else {
                result[ni] = num;
                ni += 2;
            }
        }

        return result;
    }

    // 5 ms
    public int[] rearrangeArray2(int[] nums) {
        int n = nums.length;

        int[] pos = new int[n / 2];
        int[] neg = new int[n / 2];

        int pi = 0, ni = 0;
        for (int num : nums) {
            if (num > 0) pos[pi++] = num;
            else neg[ni++] = num;
        }

        pi = 0;
        ni = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = i % 2 == 0 ? pos[pi++] : neg[ni++];
        }

        return nums;
    }

}
