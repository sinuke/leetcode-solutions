package com.sinuke.easy;

import com.sinuke.common.data.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        var result = head == null ? null : new ListNode(head.val);
        var curr = result;

        while (head != null) {
            if (curr.val != head.val) {
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }

            head = head.next;
        }

        return result;
    }

}
