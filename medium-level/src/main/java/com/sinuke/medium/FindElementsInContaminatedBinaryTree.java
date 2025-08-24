package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElementsInContaminatedBinaryTree {

    public static class FindElements {

        private final Set<Integer> values = new HashSet<>();

        public FindElements(TreeNode root) {
            root.val = 0;
            this.values.add(0);

            restore(root);
        }

        public boolean find(int target) {
            return values.contains(target);
        }

        private void restore(TreeNode node) {
            int x = node.val;

            if (node.left != null) {
                node.left.val = 2 * x + 1;
                values.add(node.left.val);
                restore(node.left);
            }

            if (node.right != null) {
                node.right.val = 2 * x + 2;
                values.add(node.right.val);
                restore(node.right);
            }
        }
    }

}
