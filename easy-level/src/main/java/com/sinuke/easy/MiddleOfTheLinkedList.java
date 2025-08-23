package com.sinuke.easy;

import com.sinuke.common.data.ListNode;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        var slow = head;
        var fast = head.next;

        while (fast != null) {
            if (fast.next == null) return slow.next == null ? slow : slow.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
