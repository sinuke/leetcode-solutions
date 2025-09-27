package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            var sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;

            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode deserialize(Queue<String> queue, int lower, int upper) {
            if (queue.isEmpty()) return null;

            int val = Integer.parseInt(queue.peek());
            if (val < lower || val > upper) return null;
            queue.poll();
            TreeNode root = new TreeNode(val);
            root.left = deserialize(queue, lower, val);
            root.right = deserialize(queue, val, upper);
            return root;
        }

    }

}
