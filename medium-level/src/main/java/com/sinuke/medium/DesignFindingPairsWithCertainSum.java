package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class DesignFindingPairsWithCertainSum {

    public static class FindSumPairs {

        private final int[] n1;
        private final int[] n2;
        private final Map<Integer, Integer> map;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.n1 = nums1;
            this.n2 = nums2;
            this.map = new HashMap<>();
            for (int num : nums2) map.put(num, map.getOrDefault(num, 0) + 1);
        }

        public void add(int index, int val) {
            map.put(n2[index], map.get(n2[index]) - 1);
            if (map.get(n2[index]) == 0) map.remove(n2[index]);

            n2[index] += val;
            map.put(n2[index], map.getOrDefault(n2[index], 0) + 1);
        }

        public int count(int tot) {
            int cnt = 0;
            for (int n : n1) {
                cnt += map.getOrDefault(tot - n, 0);
            }
            return cnt;
        }
    }

}
