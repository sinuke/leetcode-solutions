package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(), parent = res;

        while (head != null) {
            var node = swap(head, parent);
            head = node.next;
            parent = node;
        }

        return res.next;
    }

    private ListNode swap(ListNode node, ListNode parent) {
        if (node.next == null) {
            parent.next = node;
            return node;
        }

        var tmpNode = node;
        var nextNode = node.next;

        tmpNode.next = nextNode.next;
        node = nextNode;
        node.next = tmpNode;

        parent.next = node;

        return tmpNode;
    }

}
