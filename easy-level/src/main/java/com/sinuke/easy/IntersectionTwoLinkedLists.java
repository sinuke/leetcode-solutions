package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        var currentA = headA;
        while (currentA != null) {
            set.add(currentA);
            currentA = currentA.next;
        }

        var currentB = headB;
        while (currentB != null) {
            if (set.contains(currentB)) return currentB;
            currentB = currentB.next;
        }

        return null;
    }

    public ListNode getIntersectionNodeTwoPointers(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode currentA = headA, currentB = headB;

        while (currentA != currentB) {
            currentA = (currentA == null) ? headB : currentA.next;
            currentB = (currentB == null) ? headA : currentB.next;
        }

        return currentA;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

}
