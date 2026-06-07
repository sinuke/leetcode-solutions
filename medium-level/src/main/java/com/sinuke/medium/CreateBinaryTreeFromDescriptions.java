package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CreateBinaryTreeFromDescriptions {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>(descriptions.length + 1);

        for (int[] n : descriptions) {
            var tn = new TreeNode(n[1]);
            nodes.put(n[1], tn);
        }

        int hv = -1;
        for (int[] n : descriptions) {
            if (!nodes.containsKey(n[0])) hv = n[0];
        }
        TreeNode head = new TreeNode(hv);

        for (int[] n : descriptions) {
            if (nodes.containsKey(n[0])) {
                if (n[2] == 1) nodes.get(n[0]).left = nodes.get(n[1]);
                else nodes.get(n[0]).right = nodes.get(n[1]);
            } else {
                if (n[2] == 1) head.left = nodes.get(n[1]);
                else head.right = nodes.get(n[1]);
            }
        }

        return head;
    }

}
