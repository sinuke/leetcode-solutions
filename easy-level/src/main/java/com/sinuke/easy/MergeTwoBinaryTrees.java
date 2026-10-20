package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        else if (root2 == null) return root1;

        walk(root1, null, root2, null, false);
        return root1;
    }

    private void walk(TreeNode n1, TreeNode p1, TreeNode n2, TreeNode p2, boolean isLeft) {
        if (n2 == null) return;

        if (n1 != null && n2 != null) n1.val += n2.val;
        else if (n1 == null && n2 != null) {
            if (p1 != null) {
                n1 = new TreeNode();
                n1.val = n2.val;

                if (isLeft) p1.left = n1;
                else p1.right = n1;
            }
        }

        walk(n1.left, n1, n2.left, n2, true);
        walk(n1.right, n1, n2.right, n2, false);
    }

}
