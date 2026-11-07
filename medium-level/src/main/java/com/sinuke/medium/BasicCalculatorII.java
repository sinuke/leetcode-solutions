package com.sinuke.medium;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorII {

    public int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> operations = new LinkedList<>();

        int result = 0;
        var sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) sb.append(c);
            else {
                if (!sb.isEmpty()) doAction(nums, operations, sb);
                if (c == '+' || c == '-' || c == '*' || c == '/') operations.add(c);
            }
        }

        if (!sb.isEmpty()) doAction(nums, operations, sb);

        while (!operations.isEmpty()) {
            int n1 = nums.pollFirst();
            int n2 = nums.pollFirst();
            nums.addFirst(calc(n1, n2, operations.pollFirst()));
        }

        return nums.peekFirst();
    }

    private void doAction(Deque<Integer> nums, Deque<Character> operations, StringBuilder sb) {
        nums.add(Integer.parseInt(sb.toString()));
        sb.setLength(0);

        if (!operations.isEmpty() && (operations.peekLast() == '*' || operations.peekLast() == '/')) {
            int n1 = nums.pollLast();
            int n2 = nums.pollLast();
            nums.add(calc(n2, n1, operations.pollLast()));
        }
    }

    private int calc(int n1, int n2, char o) {
        return switch (o) {
            case '+' -> n1 + n2;
            case '-' -> n1 - n2;
            case '*' -> n1 * n2;
            default  -> n1 / n2;
        };
    }

}
