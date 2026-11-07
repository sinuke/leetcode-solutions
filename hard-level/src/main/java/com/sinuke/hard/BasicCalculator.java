package com.sinuke.hard;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        Stack<Stack<Integer>> nums = new Stack<>();
        nums.add(new Stack<>());
        Stack<Stack<Character>> op = new Stack<>();
        op.add(new Stack<>());

        var sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) sb.append(c);
            else {
                if (!sb.isEmpty()) processNumber(nums, op, sb);

                if (c == '(') {
                    nums.add(new Stack<>());
                    op.add(new Stack<>());
                } else if (c == '+' || c == '-') op.peek().add(c);
                else if (c == ')' && nums.size() > 1) {
                    int num = nums.pop().peek();
                    op.pop();
                    if (!op.peek().isEmpty()) {
                        if (op.peek().peek() == '+') nums.peek().add(nums.peek().pop() + num);
                        else if (op.peek().peek() == '-' && !nums.peek().isEmpty()) nums.peek().add(nums.peek().pop() - num);
                        else if (op.peek().peek() == '-' && nums.peek().isEmpty()) nums.peek().add(num * (-1));
                        op.peek().pop();
                    } else nums.peek().add(num);
                }
            }
        }

        if (!sb.isEmpty()) processNumber(nums, op, sb);
        //if (!op.isEmpty() && !op.peek().isEmpty() && op.peek().peek() == '-') nums.peek().add(nums.peek().pop() * (-1));

        return nums.pop().pop();
    }

    private void processNumber(Stack<Stack<Integer>> nums, Stack<Stack<Character>> op, StringBuilder sb) {
        var n = nums.peek();
        n.add(Integer.parseInt(sb.toString()));
        sb.setLength(0);

        if (!op.peek().isEmpty() && op.peek().peek() == '+') n.add(n.pop() + n.pop());
        else if (!op.peek().isEmpty() && op.peek().peek() == '-' && n.size() == 1) n.add(n.pop() * (-1));
        else if (!op.peek().isEmpty() && op.peek().peek() == '-' && n.size() > 1) {
            int n1 = n.pop();
            int n2 = n.pop();
            n.add(n2 - n1);
        }
        if (!op.peek().isEmpty()) op.peek().pop();
    }

}
