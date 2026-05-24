package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortList {

    // 51 ms
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.<ListNode>comparingInt(v -> v.val));
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            pq.add(node);
            node = next;
        }

        node = pq.poll();
        head = node;
        while (!pq.isEmpty()) {
            node.next = pq.poll();
            node = node.next;
        }

        return head;
    }

}
