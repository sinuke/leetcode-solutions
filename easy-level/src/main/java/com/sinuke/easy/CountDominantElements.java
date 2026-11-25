package com.sinuke.easy;

public class CountDominantElements {

    public int countDominantElements(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int s = 0, c = 0;
            if (i > 0) {
                s += nums[i - 1];
                c++;
            }
            if (i < nums.length - 1) {
                s += nums[i + 1];
                c++;
            }
            cnt += nums[i] * c >= s ? 1 : 0;
        }
        return cnt;
    }

}
