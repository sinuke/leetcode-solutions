package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

import java.util.Stack;

public class RemoveNodesFromLinkedList {

    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        head = stack.pop();
        int max = head.val;

        while (!stack.isEmpty()) {
            var node = stack.pop();

            if (max <= node.val) {
                node.next = head;
                head = node;
            }
            max = Math.max(max, node.val);
        }

        return head;
    }

}
