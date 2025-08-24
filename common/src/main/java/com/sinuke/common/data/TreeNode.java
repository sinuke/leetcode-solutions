package com.sinuke.common.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static int[] toArray(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root != null) {
            list.add(root.val);
            for (int val : toArray(root.left)) list.add(val);
            for (int val : toArray(root.right)) list.add(val);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    public static List<Integer> toList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doToList(root, list);
        return list;
    }

    private static void doToList(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);

        if (node.left == null && node.right != null) {
            list.add(null);
            doToList(node.right, list);
        }
    }

}
