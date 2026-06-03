package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class DeleteMiddleNodeOfLinkedList {

    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev == null) return null;
        else prev.next = slow.next;

        return head;
    }

}
