package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode node = head, start = null, sh = null, tail = null, st = null;
        while (node != null) {
            if (node.val < x) {
                if (start == null) {
                    start = node;
                    sh = start;
                } else {
                    start.next = node;
                    start = start.next;
                }
            } else {
                if (tail == null) {
                    tail = node;
                    st = tail;
                } else {
                    tail.next = node;
                    tail = tail.next;
                }
            }
            node = node.next;
            if (start != null) start.next = null;
            if (tail != null) tail.next = null;
        }
        if (sh != null) start.next = st;
        return sh != null ? sh : st;
    }

}
