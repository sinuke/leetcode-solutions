package com.sinuke.easy;

import java.util.List;

public class ConstructTheMinimumBitwiseArrayI {

    // from leetcode - 1 ms
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            ans[i] = (val & 1) == 1 ? val & ~(((val + 1) & ~val) >> 1): -1;
        }
        return ans;
    }

    // 3 ms
    public int[] minBitwiseArray2(List<Integer> nums) {
        int[] ans = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            char[] bits = Integer.toBinaryString(val).toCharArray();
            for (int j = bits.length - 1; j >= 0; j--) {
                if (j == 0 || bits[j - 1] == '0') {
                    bits[j] = '0';
                    break;
                }
            }
            int num = Integer.parseInt(new String(bits), 2);
            ans[i] = (num | (num + 1)) == val ? num : -1;
        }

        return ans;
    }

}
