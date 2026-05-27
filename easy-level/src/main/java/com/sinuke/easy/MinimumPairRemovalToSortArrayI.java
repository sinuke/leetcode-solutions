package com.sinuke.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumPairRemovalToSortArrayI {

    // 12 ms - O(N^3)
    public int minimumPairRemoval2(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));

        boolean sorted;
        int cnt = 0;
        do {
            sorted = true;
            int m = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1) > list.get(i)) sorted = false;
                if (list.get(i - 1) + list.get(i) < list.get(m) + list.get(m + 1)) m = i - 1;
            }

            if (!sorted) {
                int sum = list.get(m) + list.get(m + 1);
                list.remove(m);
                list.set(m, sum);
                cnt++;
            }
        } while (!sorted);

        return cnt;
    }

    // 2 ms
    public int minimumPairRemoval(int[] nums) {
        ListNode head = new ListNode(nums[0]), node = head;
        int size = nums.length;
        for (int i = 1; i < size; i++) {
            ListNode next = new ListNode(nums[i]);
            next.prev = node;
            node.next = next;
            node = node.next;
        }

        boolean sorted;
        int cnt = 0;
        do {
            sorted = true;
            ListNode m = head, prev = m;
            node = m.next;
            while (node != null) {
                if (prev.val > node.val) sorted = false;
                if (m.val + m.next.val > prev.val + node.val) m = prev;
                prev = node;
                node = node.next;
            }

            if (!sorted) {
                int sum = m.val + m.next.val;
                node = m.next;
                node.val = sum;
                if (m == head) {
                    head = node;
                    head.prev = null;
                } else {
                    prev = m.prev;
                    prev.next = node;
                    node.prev = prev;
                }
                cnt++;
            }
        } while (!sorted);

        return cnt;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }

    }

}
