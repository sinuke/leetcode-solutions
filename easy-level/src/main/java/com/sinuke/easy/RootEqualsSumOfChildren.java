package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class RootEqualsSumOfChildren {

    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }

}
