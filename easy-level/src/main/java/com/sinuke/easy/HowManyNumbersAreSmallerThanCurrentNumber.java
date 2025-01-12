package com.sinuke.easy;

public class HowManyNumbersAreSmallerThanCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] set = new int[101];
        for (int num : nums) set[num]++;

        int counter = 0;
        for (int i = 0; i < 101; i++) {
            if (set[i] > 0) {
                int tmp = set[i];
                set[i] = counter;
                counter += tmp;
            }
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
            result[i] = set[nums[i]];

        return result;
    }

}
