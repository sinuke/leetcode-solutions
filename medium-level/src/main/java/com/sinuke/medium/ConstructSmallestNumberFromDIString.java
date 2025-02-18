package com.sinuke.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ConstructSmallestNumberFromDIString {

    public String smallestNumber(String pattern) {
        var sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>(List.of('1'));

        for (var c : pattern.toCharArray()) {
            char maxSorChar = stack.peek();

            if (c == 'I') {
                while (!stack.isEmpty()) {
                    maxSorChar = (char) Math.max(maxSorChar, stack.peek());
                    sb.append(stack.pop());
                }
            }

            stack.push((char) (maxSorChar + 1));
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}
