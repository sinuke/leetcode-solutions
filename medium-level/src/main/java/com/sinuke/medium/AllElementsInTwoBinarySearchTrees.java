package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        walk(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        walk(root2, list2);

        List<Integer> result = new ArrayList<>(list1.size() + list2.size());
        int i = 0, j = 0;
        while (i < list1.size() || j < list2.size()) {
            if (i < list1.size() && j < list2.size()) {
                if (list1.get(i) < list2.get(j)) result.add(list1.get(i++));
                else if (list2.get(j) < list1.get(i)) result.add(list2.get(j++));
                else if (list1.get(i) == list2.get(j)) {
                    result.add(list1.get(i++));
                    result.add(list2.get(j++));
                }
            } else if (i >= list1.size()) result.add(list2.get(j++));
            else result.add(list1.get(i++));
        }

        return result;
    }

    private void walk(TreeNode node, List<Integer> list) {
        if (node == null) return;

        walk(node.left, list);
        list.add(node.val);
        walk(node.right, list);
    }

}
