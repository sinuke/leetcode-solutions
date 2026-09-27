package com.sinuke.medium;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public String reverseParentheses(String s) {
        Stack<StringBuilder> st = new Stack<>();
        st.push(new StringBuilder());
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                st.peek().append(c);
            } else if (c == '(') {
                st.push(new StringBuilder());
            } else if (c == ')') {
                var tmp = st.pop();
                st.peek().append(tmp.reverse());
            }
        }
        return st.pop().toString();
    }

}
