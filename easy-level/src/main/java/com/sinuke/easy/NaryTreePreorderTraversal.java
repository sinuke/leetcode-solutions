package com.sinuke.easy;

import com.sinuke.common.data.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>(10000);
        generate(result, root);
        return result;
    }

    private void generate(List<Integer> list, Node root) {
        if (root == null) return;
        list.add(root.val);
        root.children.forEach(c -> generate(list, c));
    }

}
