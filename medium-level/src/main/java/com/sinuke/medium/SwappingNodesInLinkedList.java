package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class SwappingNodesInLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode node = head, first = null, second = head;
        int i = 1;
        while (node != null) {
            if (i == k) {
                if (first == null) first = node;
                if (node.next != null) second = second.next;
            } else i++;
            node = node.next;
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

        return head;
    }

}
