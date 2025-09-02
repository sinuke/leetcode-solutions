package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

public class SmallestStringStartingFromLeaf {

    public String smallestFromLeaf(TreeNode root) {
        var smallest = new Smallest();
        getSmallest(root, new StringBuilder(), smallest);
        return smallest.str;
    }

    private void getSmallest(TreeNode node, StringBuilder sb, Smallest smallest) {
        if (node == null) return;

        sb.append((char) (node.val + 'a'));

        if (node.left == null && node.right == null) smallest.str = compare(smallest.str, sb.reverse().toString());
        else {
            getSmallest(node.left, new StringBuilder(sb), smallest);
            getSmallest(node.right, new StringBuilder(sb), smallest);
        }
    }

    private String compare(String str1, String str2) {
        if (str1 == null || str1.isEmpty()) return str2;
        else if (str2 == null || str2.isEmpty()) return str1;
        else return str1.compareTo(str2) < 0 ? str1 : str2;
    }

    private static class Smallest {
        String str;
    }

}
