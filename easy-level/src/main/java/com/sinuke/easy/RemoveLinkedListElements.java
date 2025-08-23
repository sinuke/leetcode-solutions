package com.sinuke.easy;

import com.sinuke.common.data.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode result = new ListNode();
        var curr = result;
        var node = head;

        while (node != null) {
            if (node.val != val) {
                curr.next  = new ListNode(node.val);
                curr = curr.next;
            }

            node = node.next;
        }

        return result.next;
    }

}
