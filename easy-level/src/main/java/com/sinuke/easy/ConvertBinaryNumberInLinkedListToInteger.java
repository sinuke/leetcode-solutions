package com.sinuke.easy;

import com.sinuke.common.data.ListNode;

public class ConvertBinaryNumberInLinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        var sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(sb.toString(), 2);
    }

}
