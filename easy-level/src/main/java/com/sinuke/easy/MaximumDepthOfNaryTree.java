package com.sinuke.easy;

import com.sinuke.common.data.Node;

public class MaximumDepthOfNaryTree {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 0;
        for (var node : root.children) {
            depth = Math.max(depth, maxDepth(node));
        }
        return depth + 1;
    }

}
