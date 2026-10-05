package com.sinuke.medium;

import java.util.Stack;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {
        Stack<Level> stack = new Stack<>();
        Level lvl = new Level();
        stack.add(lvl);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (stack.size() > 1) stack.peek().m = 2;
                stack.add(new Level());
            } else {
                lvl = stack.pop();
                lvl.s += lvl.m == 1 ? 1 : 0;
                stack.peek().s += lvl.s * lvl.m;
            }
        }
        return stack.pop().s;
    }

    private static class Level {
        int s = 0;
        int m = 1;
    }

}
