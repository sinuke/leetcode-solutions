package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        Queue<Integer> queue = Arrays.stream(preorder).boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        return build(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(Queue<Integer> q, int l, int u) {
        if (q.isEmpty()) return null;

        int val = q.peek();
        if (val < l || val > u) return null;

        q.poll();
        var node = new TreeNode(val);
        node.left = build(q, l, val);
        node.right = build(q, val, u);
        return node;
    }

}
