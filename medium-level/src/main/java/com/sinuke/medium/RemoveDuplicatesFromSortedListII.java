package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head, prev = null, next = null;
        int cnt = 0;
        while (node != null) {
            next = node.next;
            if (next != null && node.val != next.val) {
                if (cnt > 0) {
                    if (prev == null) head = next;
                    else prev.next = next;
                } else prev = node;
                node = next;
                cnt = 0;
            } else if (next != null && node.val == next.val) {
                cnt++;
                node = next;
            } else node = next;
        }

        if (cnt > 0) {
            if (prev == null) head = null;
            else prev.next = null;
        };

        return head;
    }

}
