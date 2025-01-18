package com.sinuke.easy;

public class FindTheNumberOfGoodPairsI {

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int counter = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 % (num2 * k) == 0) counter++;
            }
        }
        return counter;
    }

}
