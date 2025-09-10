package com.sinuke.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (var token : tokens) {
            switch (token) {
                case "+" -> stack.add(stack.pop() + stack.pop());
                case "-" -> {
                    int val = stack.pop();
                    stack.add(stack.pop() - val);
                }
                case "*" -> stack.add(stack.pop() * stack.pop());
                case "/" -> {
                    int divisor = stack.pop();
                    stack.add(stack.pop() / divisor);
                }
                default -> stack.add(Integer.parseInt(token));
            }
        }

        return !stack.isEmpty() ? stack.pop() : 0;
    }

}
