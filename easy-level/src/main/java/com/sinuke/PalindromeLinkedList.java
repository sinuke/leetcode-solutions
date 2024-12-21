package com.sinuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class PalindromeLinkedList {

    // fast solution - 8 ms - O(N)
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!Objects.equals(list.get(i), list.get(list.size() - i - 1))) return false;
        }

        return true;
    }

    // slow solution - 14 ms
    public boolean isPalindromeSlow(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode curr = head;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }

        while (head != null) {
            if (head.val != stack.pop()) return false;
            head = head.next;
        }

        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
