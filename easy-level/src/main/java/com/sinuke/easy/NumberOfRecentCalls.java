package com.sinuke.easy;

import java.util.Deque;
import java.util.LinkedList;

public class NumberOfRecentCalls {

    public static class RecentCounter {

        private final Deque<Integer> pings;

        public RecentCounter() {
            pings = new LinkedList<>();
        }

        public int ping(int t) {
            pings.offerLast(t);
            int val = pings.peekFirst();
            while (val < t - 3000) {
                val = pings.peekFirst();
                if (val < t - 3000) pings.pollFirst();
            }
            return pings.size();
        }
    }

}
