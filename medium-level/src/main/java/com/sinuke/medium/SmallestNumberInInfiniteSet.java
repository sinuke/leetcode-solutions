package com.sinuke.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestNumberInInfiniteSet {

    public static class SmallestInfiniteSet {

        private final PriorityQueue<Integer> pq;
        private final Set<Integer> set;
        private int min = 1;

        public SmallestInfiniteSet() {
            pq = new PriorityQueue<>();
            set = new HashSet<>();
        }

        public int popSmallest() {
            if (pq.isEmpty()) return min++;

            int value = pq.poll();
            set.remove(value);
            return value;
        }

        public void addBack(int num) {
            if (num < min && !set.contains(num)) {
                pq.offer(num);
                set.add(num);
            }
        }
    }

}
