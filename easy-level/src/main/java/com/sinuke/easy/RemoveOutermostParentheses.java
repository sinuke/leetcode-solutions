package com.sinuke.easy;

public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {
        var sb = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                counter++;
                if (counter > 1) sb.append('(');
            }

            if (s.charAt(i) == ')') {
                counter--;
                if (counter >= 1) sb.append(')');
            }
        }

        return sb.toString();
    }

}
