package com.sinuke.easy;

import java.util.Arrays;
import java.util.Stack;

public class MakeTheStringGreat {

    // 4 ms
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1;  i < s.length(); i++) {
            if (!stack.isEmpty() && isSame(stack.peek(), s.charAt(i))) {
                if (isBad(stack.peek(), s.charAt(i))) stack.pop();
                else stack.push(s.charAt(i));
            } else stack.push(s.charAt(i));
        }

        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    // 1 ms
    public String makeGood2(String s) {
        char[] chars = new char[s.length()];
        int index = 0;
        chars[index] = s.charAt(0);

        for (int i = 1;  i < s.length(); i++) {
            if (index >= 0 && chars[index] != 0 && isSame(chars[index], s.charAt(i))) {
                if (isBad(chars[index], s.charAt(i))) chars[index--] = 0;
                else chars[++index] = s.charAt(i);
            } else chars[++index] = s.charAt(i);
        }

        return new String(Arrays.copyOf(chars, index + 1));
    }

    private boolean isSame(char c1, char c2) {
        return Math.abs(c1 - c2) == 0 || Math.abs(c1 - c2) == 32;
    }

    private boolean isBad(char c1, char c2) {
        return Math.abs(c1 - c2) == 32;
    }

}
