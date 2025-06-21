package com.sinuke.easy;

import java.util.List;

public class MaximumDepthOfNaryTree {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 0;
        for (var node : root.children) {
            depth = Math.max(depth, maxDepth(node));
        }
        return depth + 1;
    }

    public static class Node {

        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

    }

}
