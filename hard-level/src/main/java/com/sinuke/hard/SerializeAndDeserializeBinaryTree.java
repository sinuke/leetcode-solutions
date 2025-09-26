package com.sinuke.hard;

import com.sinuke.common.data.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> list = new LinkedList<>();
            if (root != null) {
                list.add(String.valueOf(root.val));
                toList(root, list);
            }
            return String.join(",", list);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] array = data.split(",");

            if (array.length == 0 || isNullOrEmpty(array[0])) return null;

            var root = new TreeNode(Integer.parseInt(array[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int i = 1;
            while (i < array.length && !queue.isEmpty()) {
                var current = queue.poll();

                if (!isNullOrEmpty(array[i])) {
                    current.left = new TreeNode(Integer.parseInt(array[i]));
                    queue.offer(current.left);
                }
                i++;

                if (i < array.length && !isNullOrEmpty(array[i])) {
                    current.right = new TreeNode(Integer.parseInt(array[i]));
                    queue.offer(current.right);
                }
                i++;
            }

            return root;
        }

        public void toList(TreeNode node, List<String> list) {
            if (node.left == null && node.right == null) {
                list.add("");
                list.add("");
            } else if (node.left != null && node.right == null) {
                list.add(String.valueOf(node.left.val));
                list.add("");
                toList(node.left, list);
            } else if (node.left == null) {
                list.add("");
                list.add(String.valueOf(node.right.val));
                toList(node.right, list);
            } else {
                list.add(String.valueOf(node.left.val));
                list.add(String.valueOf(node.right.val));
                toList(node.left, list);
                toList(node.right, list);
            }
        }

        private boolean isNullOrEmpty(String str) {
            return str == null || str.isEmpty();
        }

    }

}
