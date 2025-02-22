package com.sinuke.hard;

import java.util.Stack;

public class RecoverTreeFromPreorderTraversal {

    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;

        while (index < traversal.length()) {
            int level = 0;
            while (index < traversal.length() && traversal.charAt(index) == '-') {
                level++;
                index++;
            }

            int value = 0;
            while (index < traversal.length() && Character.isDigit(traversal.charAt(index))) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            var node = new TreeNode(value);
            while (stack.size() > level) stack.pop();

            if (!stack.isEmpty()) {
                if (stack.peek().left == null) stack.peek().left = node;
                else stack.peek().right = node;
            }

            stack.push(node);
        }

        while (stack.size() > 1) stack.pop();

        return stack.pop();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
