package com.sinuke.easy;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    public static class KthLargest {

        private final PriorityQueue<Integer> pq;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.pq = new PriorityQueue<>(k + 1);
            for (int num : nums) {
                pq.offer(num);
                if (pq.size() > k) pq.poll();
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) pq.poll();
            return pq.peek();
        }

    }

}
