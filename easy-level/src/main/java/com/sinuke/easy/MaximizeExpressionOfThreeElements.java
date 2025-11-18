package com.sinuke.easy;

public class MaximizeExpressionOfThreeElements {

    public int maximizeExpressionOfThree(int[] nums) {
        int a = -1, b = -1, c = -1;

        for (int i = 0; i < nums.length; i++) {
            if (a == -1 || nums[i] >= nums[a]) {
                b = a;
                a = i;
            } else if (b == -1 || nums[i] >= nums[b]) b = i;
            if (c == -1 || nums[i] <= nums[c]) c = i;
        }

        return nums[a] + nums[b] - nums[c];
    }

}
