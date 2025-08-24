package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(100);
        generate(result, root);
        return result;
    }

    private void generate(List<Integer> list, TreeNode root) {
        if (root == null) return;
        generate(list, root.left);
        generate(list, root.right);
        list.add(root.val);
    }

}
