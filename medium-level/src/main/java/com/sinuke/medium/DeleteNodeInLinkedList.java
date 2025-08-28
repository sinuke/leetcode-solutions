package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        var parent = node;
        while (node.next != null) {
            node.val = node.next.val;
            parent = node;
            node = node.next;
        }
        parent.next = null;
    }

}
