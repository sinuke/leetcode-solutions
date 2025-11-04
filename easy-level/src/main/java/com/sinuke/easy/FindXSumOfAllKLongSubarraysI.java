package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class FindXSumOfAllKLongSubarraysI {

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length, i = 0, j = 0, m = 0;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();

        while (i < n) {
            if (j != k) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                j++;
            }

            if (j == k) {
                if (i - k >= 0 ) {
                    if (map.get(nums[i - k]) <= 1) map.remove(nums[i - k]);
                    else map.put(nums[i - k], map.get(nums[i - k]) - 1);
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                }
                ans[m++] = calc(map, x);
            }

            i++;
        }

        return ans;
    }

    private int calc(Map<Integer, Integer> map, int x) {
        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue((v1, v2) -> v2 - v1).thenComparing(Map.Entry.comparingByKey((k1, k2) -> k2 - k1)))
                .limit(x)
                .mapToInt(e -> e.getKey() * e.getValue())
                .sum();
    }

}
