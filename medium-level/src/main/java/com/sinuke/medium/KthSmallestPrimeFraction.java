package com.sinuke.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {

    // 682 ms
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[]>comparingDouble(a -> ((double) a[0])/a[1]));
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                pq.add(new int[] {arr[i], arr[j]});
            }
        }

        int[] result = pq.poll();
        k--;
        while (k > 0) {
            result = pq.poll();
            k--;
        }
        return result;
    }

}
