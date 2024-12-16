package com.sinuke;

import java.util.PriorityQueue;
import java.util.Queue;

public class FinalArrayStateAfterKMultiplicationOperationsI {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) return nums;

        Queue<int[]> pq = new PriorityQueue<>(nums.length, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

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
