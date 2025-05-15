package com.sinuke.easy;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) stack.pop();
            else stack.push(c);
        }
        return stack.stream().map(Object::toString).collect(Collectors.joining());
    }

}
