package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

    // 13 ms
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Degree> map = new HashMap<>();
        var maxDegree = new Degree();
        maxDegree.count = 1;
        maxDegree.start = 0;
        maxDegree.end = 0;
        maxDegree.length = 1;
        map.put(nums[0], maxDegree);

        for (int i = 1; i < nums.length; i++) {
            Degree degree;
            if (map.containsKey(nums[i])) {
                degree = map.get(nums[i]);
                degree.count++;
            } else {
                degree = new Degree();
                degree.count = 1;
                degree.start = i;
                map.put(nums[i], degree);
            }

            degree.end = i;
            degree.length = degree.end - degree.start + 1;

            if (degree.count > maxDegree.count) maxDegree = degree;
            else if (degree.count == maxDegree.count && degree.length < maxDegree.length) maxDegree = degree;
        }

        return maxDegree.length;
    }

    // 109 ms
    public int findShortestSubArray2(int[] nums) {
        int[][] dp = new int[50_000][4];
        dp[nums[0]][0] = 1;
        dp[nums[0]][1] = 0;
        dp[nums[0]][2] = 0;
        dp[nums[0]][3] = 1;

        int[] max = dp[nums[0]];

        for (int i = 1; i < nums.length; i++) {
            if (dp[nums[i]][0] > 0) dp[nums[i]][0]++;
            else {
                dp[nums[i]][0] = 1;
                dp[nums[i]][1] = i;
            }

            dp[nums[i]][2] = i;
            dp[nums[i]][3] = dp[nums[i]][2] - dp[nums[i]][1] + 1;

            if (dp[nums[i]][0] > max[0]) max = dp[nums[i]];
            else if (dp[nums[i]][0] == max[0] && dp[nums[i]][3] < max[3]) max = dp[nums[i]];
        }

        return max[3];
    }

    private static class Degree {
        int count;
        int start;
        int end;
        int length;
    }

}
