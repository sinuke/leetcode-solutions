package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class MergeNodesInBetweenZeros {

    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode(), node = result, parent = null;
        int sum = 0;

        while (head != null) {
            if (head.val == 0 && sum != 0) {
                node.val = sum;
                node.next = new ListNode();
                parent = node;
                node = node.next;

                sum = 0;
            } else if (head.val != 0) sum += head.val;

            head = head.next;
        }

        if (parent != null) parent.next = null;
        return result;
    }

}
