package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode(-1, head), node = root, leftNode = null, prevLeft = null;
        int index = 0;

        while (node.next != null) {
            if (index == left - 1) {
                prevLeft = node;
                node = node.next;
                prevLeft.next = null;
                leftNode = node;
            } else if (index >= left && index < right) {
                var next = node.next;
                node.next = next.next;
                next.next = leftNode;
                leftNode = next;
            } else node = node.next;

            index++;
        }
        prevLeft.next = leftNode;

        return root.next;
    }

}
