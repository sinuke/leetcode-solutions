package com.sinuke.easy;

import java.util.List;

public class MaximumDepthOfNaryTree {

    public int maxDepth(Node root) {
        if (root.children == null || root.children.isEmpty()) return 1;
        return 1 + root.children.stream().mapToInt(this::maxDepth).max().getAsInt();
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
