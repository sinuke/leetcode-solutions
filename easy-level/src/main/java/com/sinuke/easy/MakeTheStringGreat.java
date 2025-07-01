package com.sinuke.easy;

import java.util.Arrays;
import java.util.Stack;

public class MakeTheStringGreat {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1;  i < s.length(); i++) {
            if (!stack.isEmpty() && isSame(stack.peek(), s.charAt(i))) {
                if (isBad(stack.peek(), s.charAt(i)) || isBad(s.charAt(i), stack.peek())) stack.pop();
                else stack.push(s.charAt(i));
            } else stack.push(s.charAt(i));
        }

        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public String makeGood2(String s) {
        char[] chars = new char[s.length()];
        int index = 0;
        chars[index] = s.charAt(0);

        for (int i = 1;  i < s.length(); i++) {
            if (index >= 0 && chars[index] != 0 && isSame(chars[index], s.charAt(i))) {
                if (isBad(chars[index], s.charAt(i)) || isBad(s.charAt(i), chars[index])) chars[index--] = 0;
                else chars[++index] = s.charAt(i);
            } else chars[++index] = s.charAt(i);
        }

        return new String(Arrays.copyOf(chars, index + 1));
    }

    private boolean isSame(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }

    private boolean isBad(char c1, char c2) {
        return Character.isUpperCase(c1) && Character.isLowerCase(c2);
    }

}
