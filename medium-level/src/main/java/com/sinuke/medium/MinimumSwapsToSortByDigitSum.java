package com.sinuke.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToSortByDigitSum {

    public int minSwaps(int[] nums) {
        int[] sorted = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.<Integer>comparingInt(this::sum).thenComparing(i -> i))
                .mapToInt(i -> i)
                .toArray();

        return getSwaps(nums, sorted);
    }

    private int sum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    private int getSwaps(int[] n, int[] s) {
        boolean[] vis = new boolean[n.length];

        Map<Integer, Integer> map = new HashMap<>(n.length);
        for (int i = 0; i < n.length; i++) map.put(n[i], i);

        int swaps = 0;
        for (int i = 0; i < n.length; i++) {
            if (vis[i] || map.get(s[i]) == i) continue;

            int j = i, cycleSize = 0;

            while (!vis[j]) {
                vis[j] = true;
                j = map.get(s[j]);
                cycleSize++;
            }

            if (cycleSize > 0) swaps += (cycleSize - 1);
        }

        return swaps;
    }

}
