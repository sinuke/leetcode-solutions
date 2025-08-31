package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        var node = head;
        while (node != null) {
            n++;
            node = node.next;
        }

        ListNode[] parts = new ListNode[k];
        node = head;
        int c = 0, p = 0;
        parts[p] = node;
        while (node != null) {
            c++;
            if ((p < n % k && c == n / k + 1) || (p >= n % k && c == n / k)) {
                var tmp = node.next;
                node.next = null;
                node = tmp;
                if (p < k - 1) parts[++p] = node;
                c = 0;
            } else node = node.next;
        }
        return parts;
    }

}
