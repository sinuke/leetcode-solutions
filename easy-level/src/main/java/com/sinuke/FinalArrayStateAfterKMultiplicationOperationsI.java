package com.sinuke;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FinalArrayStateAfterKMultiplicationOperationsI {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) return nums;

        Queue<int[]> pq = new PriorityQueue<>(nums.length, Comparator.comparing((int[] a) -> a[0]).thenComparing(a -> a[1]));

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] {nums[i], i});
        }

        while (k > 0) {
            var node = pq.poll();
            node[0] *= multiplier;
            nums[node[1]] = node[0];
            pq.add(node);
            k--;
        }

        return nums;
    }
    
}
