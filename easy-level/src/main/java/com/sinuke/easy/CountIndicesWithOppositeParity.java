package com.sinuke.easy;

public class CountIndicesWithOppositeParity {

    public int[] countOppositeParity(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] % 2 == 0 && nums[j] % 2 != 0) || (nums[i] % 2 != 0 && nums[j] % 2 == 0)) answer[i]++;
            }
        }
        return answer;
    }

}
