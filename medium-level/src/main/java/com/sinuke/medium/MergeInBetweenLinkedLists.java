package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = 0;
        ListNode head = list1, aNode = null, bNode = null;
        while (list1 != null) {
            index++;
            if (index == a) aNode = list1;
            else if (index == b + 1) bNode = list1;
            list1 = list1.next;
        }

        aNode.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = bNode.next;
        return head;
    }

}
