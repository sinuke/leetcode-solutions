package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class SumOfRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {
        Value value = new Value();
        extractValue(root, new StringBuilder(), value);
        return value.sum;
    }

    private void extractValue(TreeNode node, StringBuilder sb, Value value) {
        if (node == null) return;

        sb.append(node.val);

        if (node.left == null && node.right == null) {
            value.sum += Integer.parseInt(sb.toString(), 2);
            return;
        }

        extractValue(node.left, new StringBuilder(sb), value);
        extractValue(node.right, new StringBuilder(sb), value);
    }

    private static class Value {
        int sum;
    }

}
