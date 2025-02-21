package com.sinuke.easy;

public class MaximumNestingDepthOfTheParentheses {

    public int maxDepth(String s) {
        int max = 0, current = 0;

        for (var c : s.toCharArray()) {
            if (c == '(') current++;
            else if (c == ')') {
                if (current > max) max = current;
                current--;
            }
        }

        return Math.max(max, current);
    }

}
