package com.sinuke.easy;

public class FindKOrOfArray {

    public int findKOr(int[] nums, int k) {
        int[] bits = new int[32];
        for (int num : nums) {
            String bin = Integer.toBinaryString(num);
            for (int i = 0; i < bin.length(); i++) {
                if (bin.charAt(i) == '1') bits[i + (32 - bin.length())]++;
            }
        }

        char[] bin = new char[32];
        for (int i = 0; i < 32; i++) {
            bin[i] = bits[i] >= k ? '1' : '0';
        }

        return Integer.parseInt(new String(bin), 2);
    }

}
