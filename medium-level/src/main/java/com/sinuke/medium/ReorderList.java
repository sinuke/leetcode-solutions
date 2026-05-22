package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReorderList {

    // 5 ms
    public void reorderList(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            dq.offerLast(node);
            node = node.next;
        }

        node = dq.pollFirst();
        head = node;
        while (!dq.isEmpty()) {
            node.next = dq.pollLast();
            node = node.next;

            if (node != null) {
                node.next = dq.pollFirst();
                node = node.next;
            }
        }
        if (node != null) node.next = null;
    }

}
