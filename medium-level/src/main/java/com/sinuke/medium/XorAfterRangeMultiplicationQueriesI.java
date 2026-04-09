package com.sinuke.medium;

public class XorAfterRangeMultiplicationQueriesI {

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] q : queries) {
            int idx = q[0];
            while (idx <= q[1]) {
                long p = ((long) nums[idx] * q[3]) % (1_000_000_007);
                nums[idx] = (int) p;
                idx += q[2];
            }
        }

        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        return xor;
    }

}
