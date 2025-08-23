package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int additional = 0;

        var curL1 = l1;
        var curL2 = l2;

        var result = new ListNode();
        var curResult = result;

        while (curL1 != null || curL2 != null) {
            int sum = 0;

            if (curL1 != null && curL2 != null) {
                sum = curL1.val + curL2.val + additional;
                if (sum >= 10) {
                    additional = 1;
                    sum -= 10;
                } else additional = 0;
                curL1 = curL1.next;
                curL2 = curL2.next;
            } else if (curL1 != null) {
                sum = curL1.val + additional;
                if (sum >= 10) {
                    additional = 1;
                    sum -= 10;
                }
                else additional = 0;
                curL1 = curL1.next;
            } else {
                sum = curL2.val + additional;
                if (sum >= 10) {
                    additional = 1;
                    sum -= 10;
                }
                else additional = 0;
                curL2 = curL2.next;
            }

            curResult.val = sum;
            if (curL1 != null || curL2 != null || additional == 1) {
                curResult.next = new ListNode();
                curResult = curResult.next;
            }
        }

        if (additional == 1) curResult.val = additional;

        return result;
    }

}
