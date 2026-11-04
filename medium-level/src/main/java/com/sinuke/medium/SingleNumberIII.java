package com.sinuke.medium;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) x ^= num;

        int i = 0;
        while (((x >> i) & 1) == 0) i++;

        int n1 = 0;
        for (int num : nums) {
            if (((num >> i) & 1) == 0) n1 ^= num;
        }

        return new int[] {n1, n1 ^ x};
    }

}
