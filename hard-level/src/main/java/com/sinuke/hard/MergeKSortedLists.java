package com.sinuke.hard;

import com.sinuke.common.data.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    // 157 ms
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode current = result;
        ListNode parent = null;

        int k = lists.length, nullCount = 0;
        while (nullCount < k) {
            int min = -1;
            nullCount = 0;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) nullCount++;
                else if (min == -1) min = i;
                else if (lists[min].val >= lists[i].val) min = i;
            }

            if (min != -1) {
                current.val = lists[min].val;
                current.next = new ListNode();
                parent = current;
                current = current.next;
                lists[min] = lists[min].next;
            }
        }
        if (parent != null) parent.next = null;
        else return null;

        return result;
    }

    // 5 ms
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ListNode list : lists) {
            var node = list;
            while (node != null) {
                pq.offer(node.val);
                node = node.next;
            }
        }

        ListNode result = pq.isEmpty() ? null : new ListNode();
        var current = result;

        while (!pq.isEmpty()) {
            current.val = pq.poll();
            if (!pq.isEmpty()) {
                current.next = new ListNode();
                current = current.next;
            }
        }

        return result;
    }

    // 9 ms
    public ListNode mergeKLists3(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();

        for (ListNode lst : lists) {
            var node = lst;
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        list.sort(Integer::compareTo);

        ListNode result = list.isEmpty() ? null : new ListNode();
        var current = result;
        for (int i = 0; i < list.size(); i++) {
            current.val = list.get(i);
            if (i < list.size() - 1) {
                current.next = new ListNode();
                current = current.next;
            }
        }

        return result;
    }

}
