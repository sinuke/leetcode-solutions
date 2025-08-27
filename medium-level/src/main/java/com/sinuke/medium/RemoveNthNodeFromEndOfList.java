package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head, nth = null, prev = null, next = head;
        int k = 1;
        while (head != null) {
            if (k < n) k++;
            else {
                prev = nth;
                nth = next;
                next = next.next;
            }

            head = head.next;
        }

        if (nth != null) {
            if (prev == null) result = nth.next;
            else prev.next = nth.next;
        }
        return result;
    }

}
