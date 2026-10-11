package com.sinuke.easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class LargestNumberAfterDigitSwapsByParity {

    public int largestInteger(int num) {
        String s = String.valueOf(num);
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (d % 2 == 0) even.add(d);
            else odd.add(d);
        }

        int res = 0;
        for (char c : s.toCharArray()) {
            res = res * 10 + ((c - '0') % 2 == 0 ? even.poll() : odd.poll());
        }
        return res;
    }

}
