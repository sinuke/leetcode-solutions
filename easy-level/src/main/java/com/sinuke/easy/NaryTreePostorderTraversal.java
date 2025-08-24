package com.sinuke.easy;

import com.sinuke.common.data.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>(10000);
        generate(result, root);
        return result;
    }

    private void generate(List<Integer> list, Node root) {
        if (root == null) return;
        root.children.forEach(c -> generate(list, c));
        list.add(root.val);
    }

}
