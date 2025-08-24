package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
         return p != null && q != null
                 ? p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
                 : p == q;
    }

}
