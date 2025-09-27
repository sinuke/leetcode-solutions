package com.sinuke.hard;

import com.sinuke.common.data.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            var sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) sb.append("#").append(",");
            else {
                sb.append(root.val).append(",");
                serialize(root.left, sb);
                serialize(root.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(queue);
        }

        private TreeNode deserialize(Queue<String> queue) {
            var s = queue.poll();
            if ("#".equals(s)) return null;

            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.left = deserialize(queue);
            root.right = deserialize(queue);
            return root;
        }

    }

}
