package com.sinuke;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return null;
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
