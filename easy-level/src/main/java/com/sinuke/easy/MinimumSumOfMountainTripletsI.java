package com.sinuke.easy;

public class MinimumSumOfMountainTripletsI {

    // 1 ms
    public int minimumSum2(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        leftMin[0] = nums[0];
        rightMin[n - 1] = nums[n - 1];

        for (int i = 1; i < n - 1; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
            rightMin[n - i - 1] = Math.min(rightMin[n - i], nums[n - i - 1]);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMin[i - 1] && nums[i] > rightMin[i + 1]) answer = Math.min(answer, leftMin[i - 1] + nums[i] + rightMin[i + 1]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // 1 ms
    public int minimumSum(int[] nums) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j]) {
                        answer = Math.min(answer, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

}
