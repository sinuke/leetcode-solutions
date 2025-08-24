package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        return p != null && q != null
                ? p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left)
                : p == q;
    }

}
