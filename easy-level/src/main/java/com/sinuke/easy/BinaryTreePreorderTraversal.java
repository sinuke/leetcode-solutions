package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(100);
        generate(result, root);
        return result;
    }

    private void generate(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        generate(list, root.left);
        generate(list, root.right);
    }

}
