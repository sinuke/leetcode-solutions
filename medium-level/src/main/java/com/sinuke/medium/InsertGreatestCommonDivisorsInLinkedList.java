package com.sinuke.medium;

public class InsertGreatestCommonDivisorsInLinkedList {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        var node = head;

        while (node != null && node.next != null) {
            if (node.val != 0 || node.next.val != 0) {
                node.next = new ListNode(nod(node.val, node.next.val), node.next);
                node = node.next;
            }
            node = node.next;
        }

        return head;
    }

    private int nod(int m, int n) {
        if (m == 0) return n;
        else if (n == 0) return m;
        else if (m == n) return m;
        else if (m % 2 == 0 && n % 2 == 0) return 2 * nod(m / 2, n / 2);
        else if (m % 2 == 0 && n % 2 != 0) return nod(m / 2, n);
        else if (m % 2 != 0 && n % 2 == 0) return nod(m, n / 2);
        else if (m % 2 != 0 && n % 2 != 0 && n > m) return nod(m, (n - m) / 2);
        else return nod((m - n) / 2, n);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

}
