package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean justStarted = true;
        while (slow != null || fast != null) {
            if (slow != null && fast != null && slow == fast && !justStarted) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

            justStarted = false;
            slow = (slow != null) ? slow.next : null;
            if (fast != null && fast.next != null) fast = fast.next.next;
            else if (fast != null) fast = null;
        }

        return null;
    }

}
