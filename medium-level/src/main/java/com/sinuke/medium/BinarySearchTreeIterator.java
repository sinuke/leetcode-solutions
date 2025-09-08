package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    public static class BSTIterator {

        private final Stack<Integer> stack;

        public BSTIterator(TreeNode root) {
            this.stack = new Stack<>();
            walk(root, this.stack);
        }

        public int next() {
            return stack.pop();
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void walk(TreeNode node, Stack<Integer> stack) {
            if (node == null) return;

            walk(node.right, stack);
            stack.add(node.val);
            walk(node.left, stack);
        }

    }

}
