package com.sinuke.easy;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode firstResult = result;

        var current1 = list1;
        var current2 = list2;

        while (current1 != null || current2 != null) {
            var tmp = new ListNode();

            if (current1 != null && current2 != null) {
                if (current2.val < current1.val) {
                    tmp.val = current2.val;
                    current2 = current2.next;
                } else {
                    tmp.val = current1.val;
                    current1 = current1.next;
                }
            } else if (current1 != null) {
                tmp.val = current1.val;
                current1 = current1.next;
            } else {
                tmp.val = current2.val;
                current2 = current2.next;
            }

            if (result != null) {
                result.next = tmp;
                result = result.next;
            } else {
                result = tmp;
                firstResult = result;
            }
        }

        return firstResult;
    }

    public static class ListNode {
        int val;
        MergeTwoSortedLists.ListNode next;

        ListNode() {

        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, MergeTwoSortedLists.ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
