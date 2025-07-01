package com.sinuke.easy;

import java.util.Stack;

public class MakeTheStringGreat {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1;  i < s.length(); i++) {
            if (!stack.isEmpty() && Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(stack.peek())) {
                if ((Character.isLowerCase(stack.peek()) && Character.isUpperCase(s.charAt(i))) || (Character.isLowerCase(s.charAt(i)) && Character.isUpperCase(stack.peek()))) stack.pop();
                else stack.push(s.charAt(i));
            } else stack.push(s.charAt(i));
        }

        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

}
