package com.sinuke.easy;

import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        var sb1 = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#' && !sb1.isEmpty()) sb1.deleteCharAt(sb1.length() - 1);
            else sb1.append(c);
        }

        var sb2 = new StringBuilder();
        for (char c : t.toCharArray()) {
            if (c == '#' && !sb2.isEmpty()) sb2.deleteCharAt(sb2.length() - 1);
            else sb2.append(c);
        }

        return sb1.compareTo(sb2) == 0;
    }

    public boolean backspaceCompare2(String s, String t) {
         Stack<Character> stack1 = new Stack<>();
         for (char c : s.toCharArray()) {
             if (c == '#' && !stack1.isEmpty()) stack1.pop();
             else stack1.push(c);
         }

         Stack<Character> stack2 = new Stack<>();
         for (char c : t.toCharArray()) {
             if (c == '#' && !stack2.isEmpty()) stack2.pop();
             else stack2.push(c);
         }

         return stack1.equals(stack2);
    }

}
